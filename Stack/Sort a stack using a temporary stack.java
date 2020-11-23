/* Question:
Given a stack of integers, sort it in descending order using another temporary stack.

Examples:

Input : [34, 3, 31, 98, 92, 23]
Output : [3, 23, 31, 34, 92, 98]

Input : [3, 5, 1, 4, 2, 8]
Output : [1, 2, 3, 4, 5, 8]   */

//Solution
class SortStack 
{ 
    // This function return the sorted stack 
    public static Stack<Integer> sortstack(Stack<Integer>  
                                             input) 
    { 
        Stack<Integer> tmpStack = new Stack<Integer>(); 
        while(!input.isEmpty()) 
        { 
            // pop out the first element 
            int tmp = input.pop(); 
          
            // while temporary stack is not empty and 
            // top of stack is greater than temp 
            while(!tmpStack.isEmpty() && tmpStack.peek()  
                                                 > tmp) 
            { 
                // pop from temporary stack and  
                // push it to the input stack 
            input.push(tmpStack.pop()); 
            } 
              
            // push temp in tempory of stack 
            tmpStack.push(tmp); 
        } 
        return tmpStack; 
    } 
