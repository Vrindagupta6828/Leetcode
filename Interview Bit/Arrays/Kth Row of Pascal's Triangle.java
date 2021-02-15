/* Question:
Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1]. 
Note:Could you optimize your algorithm to use only O(k) extra space?  */

//Solution (o(line) time and o(1) space)
public class Solution {
    public ArrayList<Integer> getRow(int A) {
         int C=1;  // C is prev element to cal the next one 
         ArrayList<Integer> row=new ArrayList<>();
         
         for(int i=1;i<=A+1;i++){
             row.add(C);
             C = C * (A - i + 1) / i;
         }
         return row;
    }
}
