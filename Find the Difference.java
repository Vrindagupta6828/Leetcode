/* Question:
You are given two strings s and t.

String t is generated by random shuffling string s and then add one more letter at a random position.

Return the letter that was added to t.

 

Example 1:

Input: s = "abcd", t = "abcde"
Output: "e"
Explanation: 'e' is the letter that was added.
Example 2:

Input: s = "", t = "y"
Output: "y"
Example 3:

Input: s = "a", t = "aa"
Output: "a"
Example 4:

Input: s = "ae", t = "aea"
Output: "a"
 

Constraints:

0 <= s.length <= 1000
t.length == s.length + 1
s and t consist of lower-case English letters.  */

//Solution (o(s+t) time and space)
class Solution {
    public char findTheDifference(String s, String t) {
        String temp=s+t;
        char res=temp.charAt(0);
        for(int i=1;i<temp.length();i++){
            res^=temp.charAt(i);
        }
        return res;
    }
}
