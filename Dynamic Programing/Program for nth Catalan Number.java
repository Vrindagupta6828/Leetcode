/* Question:
Catalan numbers are a sequence of natural numbers that occurs in many interesting counting problems like following.
1) Count the number of expressions containing n pairs of parentheses which are correctly matched. For n = 3, possible expressions are ((())), ()(()), ()()(), (())(), (()()).
2) Count the number of possible Binary Search Trees with n keys (See this)
3) Count the number of full binary trees (A rooted binary tree is full if every vertex has either two children or no children) with n+1 leaves.
4) Given a number n, return the number of ways you can draw n chords in a circle with 2 x n points such that no 2 chords intersect.
See this for more applications. 
The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …  

C_0=1 and C_n_+_1=sum{i=0 to n}C_i*C_n_-_i */

//Solution 1(Recursive)(exponential tym)

class CatalnNumber { 
  
    // A recursive function to find nth catalan number 
  
    int catalan(int n) 
    { 
        int res = 0; 
  
        // Base case 
        if (n <= 1)  
        { 
            return 1; 
        } 
        for (int i = 0; i < n; i++)  
        { 
            res += catalan(i)  
                * catalan(n - i - 1); 
        } 
        return res; 
    } 
    
  // DP(O(n^2) space and time)
   static int catalanDP(int n) 
    { 
        // Table to store results of subproblems 
        int catalan[] = new int[n + 2]; 
  
        // Initialize first two values in table 
        catalan[0] = 1; 
        catalan[1] = 1; 
  
        // Fill entries in catalan[]  
        // using recursive formula 
        for (int i = 2; i <= n; i++)  
        { 
            catalan[i] = 0; 
            for (int j = 0; j < i; j++)  
            { 
                catalan[i] 
                    += catalan[j]  
                    * catalan[i - j - 1]; 
            } 
        } 
  
        // Return last entry 
        return catalan[n]; 
    } 
    
    //Binomial coefficient(o(n) time and o(1) space)(c(n)=2*nCn/(n+1))
    // Returns value of Binomial Coefficient C(n, k) 
    static long binomialCoeff(int n, int k) 
    { 
        long res = 1; 
  
        // Since C(n, k) = C(n, n-k) 
        if (k > n - k) { 
            k = n - k; 
        } 
  
        // Calculate value of [n*(n-1)*---*(n-k+1)] / 
        // [k*(k-1)*---*1] 
        for (int i = 0; i < k; ++i) { 
            res *= (n - i); 
            res /= (i + 1); 
        } 
  
        return res; 
    } 
  
    // A Binomial coefficient based function 
    //  to find nth catalan number in O(n) time 
    static long catalan(int n) 
    { 
        // Calculate value of 2nCn 
        long c = binomialCoeff(2 * n, n); 
  
        // return 2nCn/(n+1) 
        return c / (n + 1); 
    } 
