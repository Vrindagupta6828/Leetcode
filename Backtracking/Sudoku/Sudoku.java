/* Question:
Given a partially filled 9×9 2D array ‘grid[9][9]’, the goal is to assign digits (from 1 to 9) to the empty cells so that every row, column, and subgrid of size 3×3 contains exactly one instance of the digits from 1 to 9. 



Example: 

Input:
grid = { {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
         {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
         {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
         {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
         {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
         {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
         {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
         {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
         {0, 0, 5, 2, 0, 6, 3, 0, 0} }
Output:
          3 1 6 5 7 8 4 9 2
          5 2 9 1 3 4 7 6 8
          4 8 7 6 2 9 5 3 1
          2 6 3 4 1 5 9 8 7
          9 7 4 8 6 3 1 2 5
          8 5 1 7 9 2 6 4 3
          1 3 8 9 4 7 2 5 6
          6 9 2 3 5 1 8 7 4
          7 4 5 2 8 6 3 1 9
Explanation: Each row, column and 3*3 box of 
the output matrix contains unique numbers.

Input:    
grid = { { 3, 1, 6, 5, 7, 8, 4, 9, 2 },
         { 5, 2, 9, 1, 3, 4, 7, 6, 8 },
         { 4, 8, 7, 6, 2, 9, 5, 3, 1 },
         { 2, 6, 3, 0, 1, 5, 9, 8, 7 },
         { 9, 7, 4, 8, 6, 0, 1, 2, 5 },
         { 8, 5, 1, 7, 9, 2, 6, 4, 3 },
         { 1, 3, 8, 0, 4, 7, 2, 0, 6 },
         { 6, 9, 2, 3, 5, 1, 8, 7, 4 },
         { 7, 4, 5, 0, 8, 6, 3, 1, 0 } };
Output:
           3 1 6 5 7 8 4 9 2 
           5 2 9 1 3 4 7 6 8 
           4 8 7 6 2 9 5 3 1 
           2 6 3 4 1 5 9 8 7 
           9 7 4 8 6 3 1 2 5 
           8 5 1 7 9 2 6 4 3 
           1 3 8 9 4 7 2 5 6 
           6 9 2 3 5 1 8 7 4 
           7 4 5 2 8 6 3 1 9 
Explanation: Each row, column and 3*3 box of 
the output matrix contains unique numbers.  */

//Solution
/* A Backtracking program in 
Java to solve Sudoku problem */
class GFG 
{
    public static boolean isSafe(int[][] board,
                                 int row, int col,
                                 int num)
    {
        // Row has the unique (row-clash)
        for (int d = 0; d < board.length; d++) 
        {
             
            // Check if the number we are trying to
            // place is already present in
            // that row, return false;
            if (board[row][d] == num) {
                return false;
            }
        }
 
        // Column has the unique numbers (column-clash)
        for (int r = 0; r < board.length; r++) 
        {
             
            // Check if the number 
            // we are trying to
            // place is already present in
            // that column, return false;
            if (board[r][col] == num) 
            {
                return false;
            }
        }
 
        // Corresponding square has
        // unique number (box-clash)
        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;
 
        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++) 
        {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++) 
            {
                if (board[r][d] == num) 
                {
                    return false;
                }
            }
        }
 
        // if there is no clash, it's safe
        return true;
    }
 
    public static boolean solveSudoku(
        int[][] board, int n)
    {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (board[i][j] == 0) 
                {
                    row = i;
                    col = j;
 
                    // We still have some remaining
                    // missing values in Sudoku
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
 
        // No empty space left
        if (isEmpty) 
        {
            return true;
        }
 
        // Else for each-row backtrack
        for (int num = 1; num <= n; num++) 
        {
            if (isSafe(board, row, col, num)) 
            {
                board[row][col] = num;
                if (solveSudoku(board, n)) 
                {
                    // print(board, n);
                    return true;
                }
                else
                {
                    // replace it
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }
 
    public static void print(
        int[][] board, int N)
    {
         
        // We got the answer, just print it
        for (int r = 0; r < N; r++) 
        {
            for (int d = 0; d < N; d++)
            {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");
 
            if ((r + 1) % (int)Math.sqrt(N) == 0)
            {
                System.out.print("");
            }
        }
    }
 
    // Driver Code
    public static void main(String args[])
    {
 
        int[][] board = new int[][] {
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        int N = board.length;
 
        if (solveSudoku(board, N)) 
        {
            // print solution
            print(board, N);
        }
        else {
            System.out.println("No solution");
        }
    }
}
 
// This code is contributed
// by MohanDas
Output
3 1 6 5 7 8 4 9 2 
5 2 9 1 3 4 7 6 8 
4 8 7 6 2 9 5 3 1 
2 6 3 4 1 5 9 8 7 
9 7 4 8 6 3 1 2 5 
8 5 1 7 9 2 6 4 3 
1 3 8 9 4 7 2 5 6 
6 9 2 3 5 1 8 7 4 
7 4 5 2 8 6 3 1 9 
Complexity Analysis:  

Time complexity: O(9^(n*n)). 
For every unassigned index, there are 9 possible options so the time complexity is O(9^(n*n)). The time complexity remains the same but there will be some early pruning so the time taken will be much less than the naive algorithm but the upper bound time complexity remains the same.
Space Complexity: O(n*n). 
To store the output array a matrix is needed.
