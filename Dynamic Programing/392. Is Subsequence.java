/* Question:
Given a string s and a string t, check if s is subsequence of t.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 

Constraints:

0 <= s.length <= 100
0 <= t.length <= 10^4
Both strings consists only of lowercase characters.  */

//Solution 1(o(n*m) time and space)
class Solution {
    static int[][] dp;
    public boolean isSubsequence(String s, String t) {
        int n=s.length(),m=t.length();
        dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
           for(int j=0;j<=m;j++){
               if(i==0 || j==0)
                   dp[i][j]=0;
               else if(s.charAt(i-1)==t.charAt(j-1))
                   dp[i][j]=1+dp[i-1][j-1];
               else
                   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
           }
        }
        return dp[n][m]==s.length();
    }
}

//Solution 2(o(t) time and o(1) space)
class Solution {

    public boolean isSubsequence(String s, String t) {
        Integer leftBound = s.length(), rightBound = t.length();
        Integer pLeft = 0, pRight = 0;

        while (pLeft < leftBound && pRight < rightBound) {
            // move both pointers or just the right pointer
            if (s.charAt(pLeft) == t.charAt(pRight)) {
                pLeft += 1;
            }
            pRight += 1;
        }
        return pLeft == leftBound;
    }
}
