/* Question:
Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

 

Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 

Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 105  */

//Solution o(n) time and o(1) space
class Solution {
    public int longestSubstring(String s, int k) {
        int n=s.length();
        if(n==0 || n<k) return 0;
        if(k<=1) return n;
        
        HashMap<Character,Integer> freq=new HashMap<>();
        for(char c:s.toCharArray())
            freq.put(c,freq.getOrDefault(c,0)+1);
        
        int l=0;
        while(l<n && freq.get(s.charAt(l))>=k) l++;
        if(l>=n-1) return l;
        
        int ls1=longestSubstring(s.substring(0,l),k);
        while(l<n && freq.get(s.charAt(l))<k) l++;
        
        int ls2=l<n-1?longestSubstring(s.substring(l),k):0;
        
        return Math.max(ls1,ls2);
    }
}
