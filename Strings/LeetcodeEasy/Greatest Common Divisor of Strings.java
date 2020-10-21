/* Question:
For two strings s and t, we say "t divides s" if and only if s = t + ... + t  (t concatenated with itself 1 or more times)

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

 

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
Example 4:

Input: str1 = "ABCDEF", str2 = "ABC"
Output: ""
 

Constraints:

1 <= str1.length <= 1000
1 <= str2.length <= 1000
str1 and str2 consist of English uppercase letters.   */


//Solution:(o(n) time)
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(str2.equals("")) return str1;
        while(str1.length()>=str2.length())
        {if (!str1.substring(0,str2.length()).equals(str2)) return "";
            str1=str1.substring(str2.length(),str1.length());}
            return gcdOfStrings(str2,str1);
    }
}
