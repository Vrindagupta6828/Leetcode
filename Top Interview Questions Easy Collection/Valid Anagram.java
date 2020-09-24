Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?  */

//My Solution(2 ms 96%)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())  return false;
        char[] a=s.toCharArray();Arrays.sort(a);
        char[] b=t.toCharArray();Arrays.sort(b);
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]) return false;
        }
        return true;
    }
}
