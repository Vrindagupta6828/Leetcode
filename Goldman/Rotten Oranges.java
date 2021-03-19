/* Question:
Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

We have to determine what is the minimum time required to rot all oranges. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. 
 

Example 1:

Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
Output: 1
Explanation: The grid is-
0 1 2
0 1 2
2 1 1
Oranges at positions (0,2), (1,2), (2,0)
will rot oranges at (0,1), (1,1), (2,2) and 
(2,1) in unit time.
Example 2:

Input: grid = {{2,2,0,1}}
Output: -1
Explanation: The grid is-
2 2 0 1
Oranges at (0,0) and (0,1) can't rot orange at
(0,3).
 

Your Task:
You don't need to read or print anything, Your task is to complete the function orangesRotting() which takes grid as input parameter and returns the minimum time to rot all the fresh oranges. If not possible returns -1.
 

Expected Time Compelxity: O(n*m)
Expected Auxiliary Space: O(1)
 

Constraints:
1 ≤ n, m ≤ 500   */

//Solution:
class Solution
{
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n=grid.length,m=grid[0].length;
        Queue<int[]> bfsq=new LinkedList<>();
        int[][] dist=new int[n][m];
        
        for(int[] inner:dist)  Arrays.fill(inner,-1);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2)
                {   dist[i][j]=0;
                    bfsq.add(new int[]{i,j});
                }
            }
        }
        
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        
        while(!bfsq.isEmpty()){
            int[] curr=bfsq.poll();
            int currx=curr[0];
            int curry=curr[1];
            for(int i=0;i<4;i++){
                int newx=currx+dx[i];
                int newy=curry+dy[i];
                if(isValid(newx,newy,n,m) && grid[newx][newy]!=0 
                       && dist[newx][newy]==-1)
                {
                    dist[newx][newy]=dist[currx][curry]+1;
                    bfsq.add(new int[]{newx,newy});
                }
            }
        }
        
        int max=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && dist[i][j]==-1)
                   return -1;
                max=Math.max(max,dist[i][j]);
            }
        }
        
        return max;
    }
    
    private boolean isValid(int x,int y,int n,int m){
        if(x<0 || y<0 || x>=n || y>=m) return false;
        return true;
    }
}
