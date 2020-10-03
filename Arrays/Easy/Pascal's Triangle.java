/* Problem:
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]  */

// Solution1(0(n^2))
class Solution {
    public List<List<Integer>> generate(int numRows) {
        int i=1;
        List<List<Integer>> ans=new ArrayList<>();
        while(i<=numRows){
            List<Integer> a=new ArrayList<>();
            a.add(1);
            for(int j=2;j<=i;j++){
                int e=a.get(j-2)*(i-j+1)/(j-1);
                a.add(e);
            }
            i++;
            ans.add(new ArrayList<>(a));
        }
        return ans;
    }
}
