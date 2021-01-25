/* Question:
Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost to traverse through that cell. The total cost of a path to reach (m, n) is the sum of all the costs on that path (including both source and destination). You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1), and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.

For example, in the following figure, what is the minimum cost path to (2, 2)?  



The path with minimum cost is highlighted in the following figure. The path is (0, 0) –> (0, 1) –> (1, 2) –> (2, 2). The cost of the path is 8 (1 + 2 + 2 + 3).  

*/

// Solution 1(Recursive exponential)
  /* Returns cost of minimum cost path 
    from (0,0) to (m, n) in mat[R][C]*/
    static int minCost(int cost[][], int m,
                                     int n)
    {
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        else if (m == 0 && n == 0)
            return cost[m][n];
        else
            return cost[m][n] + 
                min( minCost(cost, m-1, n-1),
                     minCost(cost, m-1, n), 
                     minCost(cost, m, n-1) );
    }
    
//Solution 2 dp(o(m*n) time and space)
private static int minCost(int cost[][], int m, int n)
    {
        int i, j;
        int tc[][]=new int[m+1][n+1];
 
        tc[0][0] = cost[0][0];
 
        /* Initialize first column of total cost(tc) array */
        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i-1][0] + cost[i][0];
 
        /* Initialize first row of tc array */
        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j-1] + cost[0][j];
 
        /* Construct rest of the tc array */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                tc[i][j] = min(tc[i-1][j-1], 
                               tc[i-1][j],
                               tc[i][j-1]) + cost[i][j];
 
        return tc[m][n];
    }
    
  //Solution 3(to optimise space)
  static int minCost(int cost[][]) 
{ 
  // for 1st column 
  for (int i = 1; i < row; i++)
  { 
    cost[i][0] += cost[i - 1][0]; 
  } 
 
  // for 1st row 
  for (int j = 1; j < col; j++)
  { 
    cost[0][j] += cost[0][j - 1]; 
  } 
 
  // for rest of the 2d matrix 
  for (int i = 1; i < row; i++) 
  { 
    for (int j = 1; j < col; j++) 
    { 
      cost[i][j] += Math.min(cost[i - 1][j - 1], 
                    Math.min(cost[i - 1][j], 
                             cost[i][j - 1])); 
    } 
  } 
 
  // Returning the value in 
  // last cell 
  return cost[row - 1][col - 1]; 
}
  
    
