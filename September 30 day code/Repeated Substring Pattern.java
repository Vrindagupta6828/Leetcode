/* Problem
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)  */

//Solution(15 ms)

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        //RECURSION
        //if get abcabcabcabc
        //divide in half: abcabc
        //check if rest of string matches -> if it does then return true!
        
        int length = s.length();
        
        for(int i = length/2; i>=1; i--) {
            if(length%i == 0) {
                int numRepeats = length/i;
                //checks that length of string is dividible by length of substring
                //if divisible by sunstring, get number of repeats
                String substring = s.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < numRepeats; j++) {
                    sb.append(substring);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
