/* Question:
Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case), */

//Solution 1(o(n^3))
class Solution {
    public String longestPalindrome(String s) {
        int maxl=1,n=s.length(),start=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int flag=1;
                
                for(int k=0;k<(j-i+1)/2;k++){
                    if(s.charAt(i+k)!=s.charAt(j-k))
                    {   flag=0;
                        break;
                    }
                }
                
                if(flag==1 && j-i+1>maxl)
                {  start=i;
                   maxl=j-i+1;
                }
            }
        }
        return s.substring(start,start+maxl);
    }
}

//Solution 2(o(n^2))
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length(),start=0,maxl=1;
        boolean[][] dp=new boolean[n][n];
        
        for(int i=0;i<n;i++)
             dp[i][i]=true;
        
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                start=i;
                maxl=2;
            }
        }
        
        for(int k=3;k<=n;k++){
            for(int i=0;i<n-k+1;i++){
                int j=i+k-1;
                
                if(dp[i+1][j-1] && s.charAt(i)==s.charAt(j))
                {   dp[i][j]=true;
            
                    if(k>maxl){
                        start=i;
                        maxl=k;
                    }
                }
            }
        }
        
        return s.substring(start,start+maxl);
    }
}
