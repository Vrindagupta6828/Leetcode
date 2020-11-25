/* Question:
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

Methods pop, top and getMin operations will always be called on non-empty stacks.  */

//Solution
class MinStack {
     Deque<Integer> stack;
     Deque<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new ArrayDeque<>();
        min=new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(min.isEmpty())
        { min.push(x);
        }
        else
        {  if(x<min.peek()) min.push(x);
           else min.push(min.peek());
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            min.pop();
            stack.pop();}
    }
    
    public int top() {
        if(!stack.isEmpty())
        return stack.peek();
        else return -1;
    }
    
    public int getMin() {
        if(!min.isEmpty())
        return min.peek();
        else return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
