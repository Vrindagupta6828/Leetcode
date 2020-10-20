/* Question:
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.  */

//Solution 1
class Solution {
    public boolean isValid(String s) {
        Stack<Character> temp=new Stack<>();
        String open="({[";
        String close=")}]";
        for(int i=0;i<s.length();i++){
            char check=s.charAt(i);
            if(open.contains(Character.toString(check))) temp.push(check);
            else if(!temp.empty() && temp.peek()==open.charAt(close.indexOf(check)))
                temp.pop();
            else return false;
            }
        return (temp.empty());
           
    }
}

//Solution 2
class Solution {
    
    private HashMap<Character,Character> mapping;
    
    public Solution(){
        this.mapping=new HashMap<Character,Character>();
        this.mapping.put(')','(');
        this.mapping.put('}','{');
        this.mapping.put(']','[');
    }
    
    public boolean isValid(String s) {
        Stack<Character> temp=new Stack<>();
        for(int i=0;i<s.length();i++){
            char check=s.charAt(i);
            if(mapping.containsKey(check)){
                if(!temp.empty() && temp.peek()==mapping.get(check))
                    temp.pop();
                else return false;
            }else
            temp.push(check);}
            
        return (temp.empty());
           
    }
}
