/* Question:
Given a NxN matrix of positive integers. There are only three possible moves from a cell Matrix[r][c].

Matrix [r+1] [c]
Matrix [r+1] [c-1]
Matrix [r+1] [c+1]
â€‹Starting from any column in row 0, return the largest sum of any of the paths up to row N-1.


Example 1:

Input: N = 2
Matrix = {{348, 391},
          {618, 193}}
Output: 1009
Explaination: The best path is 391 -> 618. 
It gives the sum = 1009.

Example 2:

Input: N = 2
Matrix = {{2, 2},
          {2, 2}}
Output: 4
Explaination: No matter which path is 
chosen, the output is 4.

Your Task:
You do not need to read input or print anything. Your task is to complete the function maximumPath() which takes the size N and the Matrix as input parameters and returns the highest maximum path sum.


Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(N*N)


Constraints:
1 ≤ N ≤ 100
1 ≤ Matrix[i][j] ≤ 1000  */

//Solution
class Solution{
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
        int[][] res=new int[N][N];
        
        for(int i=0;i<N;i++)
           res[0][i]=Matrix[0][i];
           
        for(int i=1;i<N;i++){
            for(int j=0;j<N;j++){
                if(j==0 && j+1<N)
                   res[i][j]=Matrix[i][j]+Math.max(res[i-1][j],res[i-1][j+1]);
                else if(j-1>=0 && j==N-1)
                   res[i][j]=Matrix[i][j]+Math.max(res[i-1][j],res[i-1][j-1]);
                else if(j-1>=0 && j+1<N)
                   res[i][j]=Matrix[i][j]+Math.max(res[i-1][j],
                             Math.max(res[i-1][j-1],res[i-1][j+1]));
                else
                   res[i][j]=Matrix[i][j]+res[i-1][j];
            }
        }
        int max=0;
        for(int i=0;i<N;i++){
            max=Math.max(max,res[N-1][i]);
        }
        return max;
        }
