/* Problem:
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Example 3:

Input: s = "bb"
Output: 2
 

Constraints:

1 <= s.length <= 2000
s consits of lower-case and/or upper-case English letters only. */

//Solution (100% 1 ms)
class Solution {
    public int longestPalindrome(String s) {
        
        if(s==null || s.length()==0) return 0;
        
        int n = 26 + 'a' - 'A';  // 26 + 26 + ( 'a' - 'A' - 26 )
        int[] map = new int[n];
        for(int i=0;i<s.length();i++) map[s.charAt(i)-'A']++;
        
        int ans = 0;
        boolean odd = false;
        for(int i=0;i<n;i++){
            if(map[i]%2==0) ans += map[i];
            else{
                ans += map[i]-1;
                odd = true;
            }
        }       
        
        if(odd) ans++;
        
        return ans;
    }
}
