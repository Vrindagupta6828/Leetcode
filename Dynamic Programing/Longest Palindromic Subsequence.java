/*z Question:
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
 

Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".  */

//Solution 1:(o(n*n) time and space)
class Solution {
    public int longestPalindromeSubseq(String s) {
         StringBuilder sb = new StringBuilder(s);
         String rev=(sb.reverse()).toString();
         int n=s.length();
         int[][] t=new int[n+1][n+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0)
                     t[i][j]=0;
                else if(s.charAt(i-1)==rev.charAt(j-1))
                      t[i][j]=1+t[i-1][j-1];
                else
                      t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
            }
        }
        return t[n][n];
    }
}

//Solution 2(method 2 :recursion diff aproach)
static int lps(char seq[], int i, int j) { 
    // Base Case 1: If there is only 1 character  
        if (i == j) { 
            return 1; 
        } 
  
    // Base Case 2: If there are only 2 characters and both are same  
        if (seq[i] == seq[j] && i + 1 == j) { 
            return 2; 
        } 
  
    // If the first and last characters match  
        if (seq[i] == seq[j]) { 
            return lps(seq, i + 1, j - 1) + 2; 
        } 
  
    // If the first and last characters do not match  
        return max(lps(seq, i, j - 1), lps(seq, i + 1, j)); 
    } 
  
  
  //DP of this approach(o(n*n))
  class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length(); 
    int i, j, cl; 
    // Create a table to store results of subproblems 
    int L[][] = new int[n][n];  
      
    // Strings of length 1 are palindrome of lentgh 1 
    for (i = 0; i < n; i++) 
        L[i][i] = 1; 
              
        // Build the table. Note that the lower  
        // diagonal values of table are 
        // useless and not filled in the process.  
        // The values are filled in a manner similar 
        //  to Matrix Chain Multiplication DP solution (See 
        // https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/).  
        // cl is length of substring 
        for (cl=2; cl<=n; cl++) 
        { 
            for (i=0; i<n-cl+1; i++) 
            { 
                j = i+cl-1; 
                if (s.charAt(i) == s.charAt(j) && cl == 2) 
                L[i][j] = 2; 
                else if (s.charAt(i) == s.charAt(j)) 
                L[i][j] = L[i+1][j-1] + 2; 
                else
                L[i][j] = Math.max(L[i][j-1], L[i+1][j]); 
            } 
        } 
              
        return L[0][n-1]; 
    } 
    }
