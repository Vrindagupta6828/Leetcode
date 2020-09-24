/*Problem:
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 

Constraints:

s consists only of printable ASCII characters.   */

//My Solution

class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0 || s==null || s.length()==1) return true;
        s=s.toLowerCase();
        s=s.replaceAll("[^a-z0-9]","");
        String t="";
        for(int i=0;i<s.length();i++){
            t=s.charAt(i)+t;
        }
        return (t.equals(s));
    }
}

//Solution(1 ms)
class Solution {
    public boolean isPalindrome(String s) {
        // 1， CC
        if(s == null || s.length() == 0) {
            return true;
        }
        
        // 2, GC
        int i = 0;
        int j = s.length() - 1;
        
        int ci;
        int cj;
        while(i < j) {
            ci = s.charAt(i);
            if('A' <= ci && ci <= 'Z') {
                ci -= 'A';
            } else if('a' <= ci && ci <= 'z') {
                ci -= 'a';
            } else if('0' <= ci && ci <= '9') {
                
            } 
            else {
                i++; continue;
            }
            
            cj = s.charAt(j);
            if('A' <= cj && cj <= 'Z') {
                cj -= 'A';
            } else if('a' <= cj && cj <= 'z') {
                cj -= 'a';
            } else if('0' <= cj && cj <= '9'){

            }
            else {
                j--; continue;
            }
            if(ci != cj) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
}
