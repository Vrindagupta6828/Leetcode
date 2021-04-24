/* Question:
Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.  */

//Solution
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length(),l=0;
        if(n==0 || n==1) return n;
        
        int ans=0,count=0;
        HashMap<Character,Integer> lastind=new HashMap<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(!lastind.containsKey(c) || lastind.get(c)<l)
            { count++; lastind.put(c,i);}
            else {
                ans=Math.max(ans,count);
                count=i-Math.max(lastind.get(c),l);
                l=lastind.get(c)+1;
                lastind.put(c,i);
            }
        }
        ans=Math.max(ans,count);
        return ans;
    }
}
