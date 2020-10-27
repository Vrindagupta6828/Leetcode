/* Question:
Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise. 

Return the number of negative numbers in grid.

 

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
Example 3:

Input: grid = [[1,-1],[-1,-1]]
Output: 3
Example 4:

Input: grid = [[-1]]
Output: 1
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100   */

//Solution 1(o(nlogm) time and o(1) space)
class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            int start=0,end=grid[i].length-1;
            while(start<=end){
                int mid=(start+end)/2;
                if(grid[i][mid]>=0)
                    start=mid+1;
                else{
                    count+=1+end-mid;
                    end=mid-1;
                }
            }
        }
        return count;
    }
}

//Solution 2(o(n+m))
class Solution {
    public int countNegatives(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int i=0,j=n-1;int count=0;
        while(i>=0 && i<m && j>=0 && j<n){
            if(grid[i][j]<0)
            {count+=m-i;
             j--;}
            else{
                i++;
            }
        }
        return count;
    }
}
