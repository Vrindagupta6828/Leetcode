/* Question:
Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]    */

//Solution (o(n^2) time and o(1) space)
public class Solution {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=1;i<=A;i++){
            int C=1;
            ArrayList<Integer> temp=new ArrayList<>();
            for(int j=1;j<=i;j++){
                temp.add(C);
                C=C*(i-j)/j;
            }
            ans.add(temp);
        }
        return ans;
    }
}

//Solution 2
public class Solution {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < A; i++){
            ArrayList <Integer> ar = new ArrayList<>();
            
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    ar.add(1);
                } else {
                    ar.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j - 1));
                }
            }
            ans.add(ar);
        }
        return ans;
    }
}
