/* Question:
The Problem 
Write a function that takes two parameters n and k and returns the value of Binomial Coefficient C(n, k). For example, your function should 
return 6 for n = 4 and k = 2, and it should return 10 for n = 5 and k = 2.

nCk=(n-1)C(k-1)+(n-1)C(k)  */

// Recursive Solution
static int binomialCoeff(int n, int k)
    {
 
        // Base Cases
        if (k > n)
            return 0;
        if (k == 0 || k == n)
            return 1;
 
        // Recur
        return binomialCoeff(n - 1, k - 1)
            + binomialCoeff(n - 1, k);
    }
   
//Solution 2(O(n*k) time and space)
static int binomialCoeff(int n, int k)
    {
        int C[][] = new int[n + 1][k + 1];
        int i, j;
 
        // Calculate  value of Binomial
        // Coefficient in bottom up manner
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= min(i, k); j++) {  //as for i>k not possible and also for k>i
                // Base Cases
                if (j == 0 || j == i)
                    C[i][j] = 1;
 
                // Calculate value using
                // previously stored values
                else
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
 
        return C[n][k];
    }
    
  //Solution 3(o(n*k) time and o(k) space)
  
  static int binomialCoeff(int n, int k)
    {
        int C[] = new int[k + 1];
 
        // nC0 is 1
        C[0] = 1;
 
        for (int i = 1; i <= n; i++) {
            // Compute next row of pascal
            // triangle using the previous row
            for (int j = Math.min(i, k); j > 0; j--)
                C[j] = C[j] + C[j - 1];
        }
        return C[k];
    }
