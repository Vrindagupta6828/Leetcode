/* Question:
Permutation refers to the process of arranging all the members of a given set to form a sequence. The number of permutations on a set of n elements is given by n! , where “!” represents factorial.
The Permutation Coefficient represented by P(n, k) is used to represent the number of ways to obtain an ordered subset having k elements from a set of n elements.

Mathematically it’s given as:
permu

Image Source : Wiki

Examples :

P(10, 2) = 90
P(10, 3) = 720
P(10, 0) = 1
P(10, 1) = 10
The coefficient can also be computed recursively using the below recursive formula:  
P(n, k) = P(n-1, k) + k* P(n-1, k-1)    */

//Solution 1(DP)(o(n*k) time and space)
// Returns value of Permutation  
    // Coefficient P(n, k) 
    static int permutationCoeff(int n,  
                                int k) 
    { 
        int P[][] = new int[n + 2][k + 2]; 
      
        // Calculate value of Permutation  
        // Coefficient in bottom up manner 
        for (int i = 0; i <= n; i++) 
        { 
            for (int j = 0;  
                 j <= Math.min(i, k);  
                 j++) 
            { 
                // Base Cases 
                if (j == 0) 
                    P[i][j] = 1; 
      
                // Calculate value using previosly  
                // stored values 
                else
                    P[i][j] = P[i - 1][j] +  
                               (j * P[i - 1][j - 1]); 
      
                // This step is important  
                // as P(i,j)=0 for j>i 
                P[i][j + 1] = 0; 
            } 
        } 
        return P[n][k]; 
    } 
    
    //Solution 2(o(n) time and space)
      static int permutationCoeff(int n,  
                                int k) 
    { 
        int []fact = new int[n+1]; 
      
        // base case 
        fact[0] = 1; 
      
        // Calculate value  
        // factorials up to n 
        for (int i = 1; i <= n; i++) 
            fact[i] = i * fact[i - 1]; 
      
        // P(n,k) = n! / (n - k)! 
        return fact[n] / fact[n - k]; 
    } 
    
    //Solution 3(O(n) time and O(1) space)
     static int PermutationCoeff(int n,  
                                int k) 
    { 
        int Fn = 1, Fk = 1; 
      
        // Compute n! and (n-k)! 
        for (int i = 1; i <= n; i++) 
        { 
            Fn *= i; 
            if (i == n - k) 
            Fk = Fn; 
        } 
        int coeff = Fn / Fk; 
        return coeff; 
    }
