/* Question:
Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: s = "aa"
Output: 0
Explanation: The optimal substring here is an empty substring between the two 'a's.
Example 2:

Input: s = "abca"
Output: 2
Explanation: The optimal substring here is "bc".
Example 3:

Input: s = "cbzxy"
Output: -1
Explanation: There are no characters that appear twice in s.
Example 4:

Input: s = "cabbac"
Output: 4
Explanation: The optimal substring here is "abba". Other non-optimal substrings include "bb" and "".
 

Constraints:

1 <= s.length <= 300
s contains only lowercase English letters.   */

//Solution(o(n))
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] charPos = new int[26];
        Arrays.fill(charPos, -1);
        int max = -1;
        for (int i = 0; i < s.length(); ++i) {
            if (charPos[s.charAt(i) - 'a'] == -1) {
                charPos[s.charAt(i) - 'a'] = i;
            }
            else {
                max = Math.max(max, i - charPos[s.charAt(i) - 'a'] - 1);
            }
        }
        return max;
    }
}
