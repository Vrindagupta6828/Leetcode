/* Question:
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Example 2:

Input: n = 1, k = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20
1 <= k <= n  */

//Solution 1
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans=new ArrayList<>();
        LinkedList<Integer> temp=new LinkedList<>();
        combinationSum3(k,n,temp,1);
        return ans;
    }
    
    private boolean combinationSum3(int k,int n,LinkedList<Integer> temp,int pos){
        if(k==0)
        { 
          ans.add(new ArrayList<Integer>(temp));
          return true;
        }
       if(temp.size()+(n-pos+1)<k)  return false;
        for(int i=pos;i<=n;i++){
            temp.add(i);
            combinationSum3(k-1,n,temp,i+1);
            temp.removeLast();
        }
        return false;
    }
}

//Solution2
class Solution {
  List<List<Integer>> output = new LinkedList();
  int n;
  int k;

  public void backtrack(int first, LinkedList<Integer> curr) {
    // if the combination is done
    if (curr.size() == k)
      output.add(new LinkedList(curr));

    for (int i = first; i < n + 1; ++i) {
      // add i into the current combination
      curr.add(i);
      // use next integers to complete the combination
      backtrack(i + 1, curr);
      // backtrack
      curr.removeLast();
    }
  }

  public List<List<Integer>> combine(int n, int k) {
    this.n = n;
    this.k = k;
    backtrack(1, new LinkedList<Integer>());
    return output;
  }
}

