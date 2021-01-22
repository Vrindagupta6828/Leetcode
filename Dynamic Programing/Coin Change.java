/* Question:
Given a value N, find the number of ways to make change for N cents, if we have infinite supply of each of S = { S1, S2, .. , SM } valued coins. 

Example 1:

Input:
n = 4 , m = 3
S[] = {1,2,3}
Output: 4
Explanation: Four Possible ways are:
{1,1,1,1},{1,1,2},{2,2},{1,3}.

â€‹Example 2:

Input:
n = 10 , m = 4
S[] ={2,5,3,6}
Output: 5
Explanation: Five Possible ways are:
{2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} 
and {5,5}.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function count() which accepts an array S[] its size m and n as input parameter and returns the number of ways to make change for N cents.



Expected Time Complexity: O(m*n).
Expected Auxiliary Space: O(n). 


Constraints:
1 <= n,m <= 103  */

//Solution 1(o(n) space and(o(n*m) time)
class Solution
{   public static int count( int S[], int m, int n ) 
{ 
    // table[i] will be storing the number of solutions for 
    // value i. We need n+1 rows as the table is constructed 
    // in bottom up manner using the base case (n = 0) 
    int table[]=new int[n+1]; 
  
    // Base case (If given value is 0) 
    table[0] = 1; 
  
    // Pick all coins one by one and update the table[] values 
    // after the index greater than or equal to the value of the 
    // picked coin 
    for(int i=0; i<m; i++) 
        for(int j=S[i]; j<=n; j++) 
            table[j] += table[j-S[i]]; 
  
    return table[n]; 
} 
}

//Solution 2(o(m*n) time and space)
class Solution
{
    public long count(int S[], int m, int n) 
    { 
        //code here.
        long[][] dp=new long[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j==0)
                   dp[i][j]=1L;
                else if(i==0)
                   dp[i][j]=0L;
                else if(S[i-1]<=j)
                   dp[i][j]=dp[i][j-S[i-1]]+dp[i-1][j];
                else
                   dp[i][j]=dp[i-1][j];
                
            }  
        }
        return dp[m][n];
    } 
}
