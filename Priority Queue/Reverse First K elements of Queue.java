/* Question:
Given an integer K and a queue of integers, we need to reverse the order of the first K elements of the queue, leaving the other elements in the same relative order.

Only following standard operations are allowed on queue.

enqueue(x) : Add an item x to rear of queue
dequeue() : Remove an item from front of queue
size() : Returns number of elements in queue.
front() : Finds front item.
Example 1:

Input:
5 3
1 2 3 4 5

Output: 
3 2 1 4 5

Explanation: 
After reversing the given
input from the 3rd position the resultant
output will be 3 2 1 4 5.

Example 2:

Input:
4 4
4 3 2 1

Output: 
1 2 3 4

Explanation: 
After reversing the given
input from the 4th position the resultant
output will be 1 2 3 4.
Your Task:
Complete the provided function modifyQueue that takes queue and k as parameters and returns a modified queue. The printing is done automatically by the driver code.

Expected TIme Complexity : O(n)
Expected Auxilliary Space : O(n)

Constraints:
1 <= N <= 1000
1 <= K <= N   */

//Solution 1 (O(n+k) time and O(n) space)

// Java program to reverse first k elements 
// of a queue. 
import java.util.LinkedList; 
import java.util.Queue; 
import java.util.Stack; 
  
public class Reverse_k_element_queue { 
  
    static Queue<Integer> queue; 
  
    // Function to reverse the first 
    // K elements of the Queue 
    static void reverseQueueFirstKElements(int k) 
    { 
        if (queue.isEmpty() == true
            || k > queue.size()) 
            return; 
        if (k <= 0) 
            return; 
  
        Stack<Integer> stack = new Stack<Integer>(); 
  
        // Push the first K elements into a Stack 
        for (int i = 0; i < k; i++) { 
            stack.push(queue.peek()); 
            queue.remove(); 
        } 
  
        // Enqueue the contents of stack 
        // at the back of the queue 
        while (!stack.empty()) { 
            queue.add(stack.peek()); 
            stack.pop(); 
        } 
  
        // Remove the remaining elements and enqueue 
        // them at the end of the Queue 
        for (int i = 0; i < queue.size() - k; i++) { 
            queue.add(queue.peek()); 
            queue.remove(); 
        } 
    } 
  
    // Utility Function to print the Queue 
    static void Print() 
    { 
        while (!queue.isEmpty()) { 
            System.out.print(queue.peek() + " "); 
            queue.remove(); 
        } 
    } 
  
    // Driver code 
    public static void main(String args[]) 
    { 
        queue = new LinkedList<Integer>(); 
        queue.add(10); 
        queue.add(20); 
        queue.add(30); 
        queue.add(40); 
        queue.add(50); 
        queue.add(60); 
        queue.add(70); 
        queue.add(80); 
        queue.add(90); 
        queue.add(100); 
  
        int k = 5; 
        reverseQueueFirstKElements(k); 
        Print(); 
    } 
} 
