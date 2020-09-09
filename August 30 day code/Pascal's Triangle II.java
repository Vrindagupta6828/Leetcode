/* Problem:
Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.

Notice that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Follow up:

Could you optimize your algorithm to use only O(k) extra space?

 

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]
 

Constraints:

0 <= rowIndex <= 40 */

//Solution(100% 0 ms)

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> a=new ArrayList<>();
        int half=((rowIndex+1)%2==0)?(rowIndex+1)/2-1:(rowIndex+1)/2;
        int C=1;a.add(C);
        for(int j=1;j<=rowIndex;j++){
            if(j<=half)
            { C=(int)(((rowIndex-j+1)*((long) C))/j);
                a.add(C);}
            else a.add(a.get(rowIndex-j));
        }
        return a;
    }
}

