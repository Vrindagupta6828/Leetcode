/* Question:
Given a singly linked list of characters, write a function that returns true if the given list is a palindrome, else false.
*/

//Solution O(n)
static boolean isPalindrome(Node head) 
    { 
  
        Node slow = head; 
        boolean ispalin = true; 
        Stack<Integer> stack = new Stack<Integer>(); 
  
        while (slow != null) { 
            stack.push(slow.data); 
            slow = slow.ptr; 
        } 
  
        while (head != null) { 
  
            int i = stack.pop(); 
            if (head.data == i) { 
                ispalin = true; 
            } 
            else { 
                ispalin = false; 
                break; 
            } 
            head = head.ptr; 
        } 
        return ispalin; 
    } 
} 
