/* Question:
Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

 

Example 1:

Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
Example 2:

Input: n = 2
Output: 15
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
Example 3:

Input: n = 33
Output: 66045
 

Constraints:

1 <= n <= 50   */

//Solution 1(o(n^5))
class Solution {
    int count=0;
    public int countVowelStrings(int n) {
        solve(n,0);
        return count;
        }
    
    private boolean solve(int n,int pos){
        if(n==0){
            count++;
            return true;
        }
        for(int i=pos;i<5;i++){
            solve(n-1,i);
        }
        return false;
    }
}

//Solution 2(o(n) time and space)
class Solution {
    static int[][] dp;
    public int countVowelStrings(int n) {
        if(n==0) return 0;
        if (n==1) return 5;
        dp=new int[6][n+1];
        for(int i=0;i<=5;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0)
                    dp[i][j]=0;
                else if(i==1)  //if(vowel is 1 no matter what is n count will always be 1)
                    dp[i][j]=1;
                else if(j==1) //if(n=1 count would be the no. of vowels available)
                    dp[i][j]=i;
                else  //either we choose a character possibility to hoose again so n dec if doesn't choose will not choose again also vowel dec.)
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[5][n];
    }
}

//Math(o(1) time and space)(5cn)
class Solution {
    public int countVowelStrings(int n) {
      return  (n+4)*(n+3)*(n+2)*(n+1)/24;  
    }
}
