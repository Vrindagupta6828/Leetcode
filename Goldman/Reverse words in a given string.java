/* Question:
Given a String S, reverse the string without reversing its individual words. Words are separated by dots.

Example 1:

Input:
S = i.like.this.program.very.much
Output: much.very.program.this.like.i
Explanation: After reversing the whole
string(not individual words), the input
string becomes
much.very.program.this.like.i
Example 2:

Input:
S = pqr.mno
Output: mno.pqr
Explanation: After reversing the whole
string , the input string becomes
mno.pqr

Your Task:
You dont need to read input or print anything. Complete the function reverseWords() which takes string S as input parameter and returns a string containing the words in reversed order. Each word in the returning string should also be separated by '.' 


Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)


Constraints:
1 <= |S| <= 2000  */

//Solution
class Solution {
    String reverseWords(String S) {
        // code here 
        StringBuilder sb=new StringBuilder();
        String word="";
        S+='.';
        for(int i=0;i<S.length();i++){
            word=word+S.charAt(i);
            if(S.charAt(i)=='.')
               {sb.insert(0,word);
               word="";}
        }
        
        return sb.toString().substring(0,sb.length()-1);
    }
}

//Solution 2
class Solution {
    String reverseWords(String S) {
        // code here 
        StringBuilder sb=new StringBuilder();
        S+=".";
        String[] word=S.split(".");
        
        for(int i=word.length-1;i>=0;i--){
            sb.append(word);
            sb.append(".");
        }
        
        return sb.toString().substring(0,sb.length()-1);
    }
}
