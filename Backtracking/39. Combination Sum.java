/* Question:
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
Example 4:

Input: candidates = [1], target = 1
Output: [[1]]
Example 5:

Input: candidates = [1], target = 2
Output: [[1,1]]
 

Constraints:

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
All elements of candidates are distinct.
1 <= target <= 500  */

//Solution 1
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans=new ArrayList<>();
        ArrayList<Integer> temp= new ArrayList<>();
        solve(candidates,target,temp,0);
        return ans;
    }
    
    private boolean solve(int[] candidates,int target,ArrayList<Integer> temp,int start){
        if(0==target){
            ans.add(new ArrayList<Integer>(temp));
            return true;
        }
        for(int i=start;i<candidates.length;i++){
            if(target-candidates[i]>=0)
            {temp.add(candidates[i]);
             solve(candidates,target-candidates[i],temp,i);
             temp.remove(temp.size()-1);
            }
        }
        return false;
    }
}

//Their solution (almost same)
class Solution {

    protected void backtrack(
            int remain,
            LinkedList<Integer> comb,
            int start, int[] candidates,
            List<List<Integer>> results) {

        if (remain == 0) {
            // make a deep copy of the current combination
            results.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0) {
            // exceed the scope, stop exploration.
            return;
        }

        for (int i = start; i < candidates.length; ++i) {
         // add the number into the combination 
            comb.add(candidates[i]);
            this.backtrack(remain - candidates[i], comb, i, candidates, results);
            // backtrack, remove the number from the combination 
            comb.removeLast();
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();

        this.backtrack(target, comb, 0, candidates, results);
        return results;
    }
}

Let NN be the number of candidates, TT be the target value, and MM be the minimal value among the candidates.

Time Complexity: \mathcal{O}(N^{\frac{T}{M}+1})O(N 
M
T
​	
 +1
 )
 Space Complexity: \mathcal{O}(\frac{T}{M})O( 
M
T
​	
 )
