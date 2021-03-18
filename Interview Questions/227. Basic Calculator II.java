/* Question:
Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5
 

Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.   */

//Solution
class Solution {
    public int calculate(String s) {
        HashMap<Character,Integer> p=new HashMap<>();
        p.put('/',2);
        p.put('*',2);
        p.put('+',1);
        p.put('-',1);
        Stack<Integer> operand=new Stack<>();
        Stack<Character> operator=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==' ')
                continue;
            else if(p.containsKey(c)){
                while(!operator.isEmpty() && p.get(operator.peek())>=p.get(c))
                {int a=operand.pop();
                 int b=operand.pop();
                 char op=operator.pop();
                 if(op=='+')
                    operand.push(a+b);
                 else if(op=='-')
                     operand.push(b-a);
                else if(op=='*')
                     operand.push(b*a);
                else if(op=='/')
                     operand.push(b/a);}
                operator.push(c);
                
            }
            else{
                int n=0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    n=n*10+Integer.parseInt(String.valueOf(s.charAt(i)));i++;
                }
                operand.push(n);
                i--;
            }
        }

        while(operand.size()>1){
        int a=operand.pop();
        int b=operand.pop();
        char op=operator.pop();
        if(op=='+')
            operand.push(a+b);
        else if(op=='-')
            operand.push(b-a);
        else if(op=='*')
            operand.push(b*a);
        else if(op=='/')
            operand.push(b/a);
        }
        return operand.pop();
    }
}

//Solution 2
class Solution {
    public int calculate(String s) {

        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                }
                else if (operation == '+') {
                    stack.push(currentNumber);
                }
                else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                }
                else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
