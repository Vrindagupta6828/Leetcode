/* Question:
Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

 

Example 1:


Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
Example 2:


Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1   */

//Solution
class Solution {
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        
        Queue<int[]> bfsq=new LinkedList<>();
        int[][] res=new int[n][n];
            
        for(int[] inner:res)
            Arrays.fill(inner,-1);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    res[i][j]=0;
                    bfsq.add(new int[]{i,j});}
            }
        }
        
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        
        while(!bfsq.isEmpty()){
            int[] curr=bfsq.poll();
            int curr_x=curr[0];
            int curr_y=curr[1];
            
            for(int i=0;i<4;i++){
                int x=curr_x+dx[i];
                int y=curr_y+dy[i];
                int[] neigh=new int[]{x,y};
                
                if(isValid(neigh,n) && res[x][y]==-1)
                {    res[x][y]=res[curr_x][curr_y]+1;
                     bfsq.add(neigh);
                }
            }
        }
        
        return findmax(res,n);
        
    }
    
    public boolean isValid(int[] neigh, int n){
        if(neigh[0]<0 || neigh[1]<0 || neigh[0]>=n || neigh[1]>=n) return false;
        return true;
    }
    
    public int findmax(int[][] res,int n){
        int ans=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans=Math.max(ans,res[i][j]);
            }
        }
        return ans==0?-1:ans;
    }
}  
