/* Question:
Given two strings s and t. Find the minimum number of operations that need to be performed on str1 to convert it to str2. The possible operations are:

Insert
Remove
Replace
 

Example 1:

Input: 
s = "geek", t = "gesek"
Output: 1
Explanation: One operation is required 
inserting 's' between two 'e's of str1.

Example 2:

Input : 
s = "gfg", t = "gfg"
Output: 
0
Explanation: Both strings are same.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function editDistance() which takes strings s and t as input parameters and returns the minimum number of operation required to make both strings equal. 

 

Expected Time Complexity: O(n2)
Expected Space Complexity: O(n2)
 

Constraints:
1 <= Length of both strings <= 100
Both the strings are in lowercase.  */

//Solution(o(n*n) time and space)
class Solution
{   static int[][] dp;
    public int editDistance(String s, String t)
    {
        // Code here
        int n=s.length(),m=t.length();
        dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0) dp[i][j]=j;
                else if(j==0) dp[i][j]=i;
                else{
                    if(s.charAt(i-1)==t.charAt(j-1))
                        dp[i][j]=dp[i-1][j-1];
                    else
                       dp[i][j]=1+Math.min(dp[i-1][j],
                       Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }}
            return dp[n][m];
    }
    }
