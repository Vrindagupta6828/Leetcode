/* Question:
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?   */

//Solution 1(O(m+n) time and space)
class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='#' && sb1.length()!=0)
                sb1.setLength(sb1.length() - 1);
            else if (S.charAt(i)!='#') sb1.append(S.charAt(i));
        }
        for(int i=0;i<T.length();i++){
            if(T.charAt(i)=='#' && sb2.length()!=0)
               sb2.setLength(sb2.length() - 1);
            else if(T.charAt(i)!='#') sb2.append(T.charAt(i));
        }
            return (sb1.toString().equals(sb2.toString()));
    }
}

//Solution 2(O(m+n) time and space)
class Solution {
    public boolean backspaceCompare(String S, String T) {
       return build(S).equals(build(T));
    }
    
    private String build(String s){
        Stack<Character> a=new Stack<>();
        for(char c:s.toCharArray()){
            if(c!='#')
                a.push(c);
            else if(!a.empty())
                a.pop();
        }
        return String.valueOf(a);
    }
}

//Solution 3(O(m+n) time and O(1) space) Two Pointers
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i=S.length()-1,j=T.length()-1;
        int sSkip=0,tSkip=0;
        while(i>=0 || j>=0){
            
            while(i>=0){
                if(S.charAt(i)=='#'){sSkip++;i--;}
                else if(sSkip>0){sSkip--;i--;}
                else break;
            }
             while(j>=0){
                if(T.charAt(j)=='#'){tSkip++;j--;}
                else if(tSkip>0){tSkip--;j--;}
                else break;
            }
            
            if(i>=0 && j>=0 && S.charAt(i)!=T.charAt(j))
                return false;
            if (i>=0 != j>=0)
                return false;
          i--;j--;
        }
        return true;
}}
