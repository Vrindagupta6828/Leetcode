/*  
Problem:
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 

Constraints:

s consists only of printable ASCII characters.  */
 
//My solution

class Solution {
2
    public boolean isPalindrome(String s) {
3
        if (s.isEmpty())  return true; 
4
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
5
        StringBuilder input1 = new StringBuilder(); 
6
  
7
        // append a string into StringBuilder input1 
8
        input1.append(str); 
9
  
10
        // reverse StringBuilder input1 
11
        input1 = input1.reverse();
12
        return((input1.toString()).equals(str));
13
        
14
    }
15
}

//6 ms

class Solution {
    public boolean isPalindrome(String s) {
        
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
        }
        return true;
    }
}
