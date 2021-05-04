/* Question:
Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100  */

//Solution
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length,j;
        List<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<=n/2;i++){
            for(j=i;j<m-i;j++){
                ans.add(matrix[i][j]);
            }
            if(ans.size()==n*m) break;
            int p=m-1-i;
            for(j=i+1;j<n-i;j++)
                ans.add(matrix[j][p]);
            
            if(ans.size()==n*m) break;
            p=n-1-i;
            for(j=m-2-i;j>=i;j--){
                ans.add(matrix[p][j]);
            }
            
            if(ans.size()==n*m) break;
            for(j=n-2-i;j>i;j--){
                ans.add(matrix[j][i]);
            }
        }
        
        return ans;
    }
}
