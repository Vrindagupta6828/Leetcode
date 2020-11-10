/* Question:
Given a singly linked list of N nodes. The task is to find the middle of the linked list. For example, if given linked list is 1->2->3->4->5 then the output should be 3.
If there are even nodes, then there would be two middle nodes, we need to print the second middle element. For example, if given linked list is 1->2->3->4->5->6 then the output should be 4.

Example 1:

Input:
LinkedList: 1->2->3->4->5
Output: 3

Example 2: 

Input:
LinkedList: 2->4->6->7->5->1
Output: 7

Your Task:
The task is to complete the function getMiddle() which takes a head reference as the only argument and should return the data at the middle node of the linked list.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 5000  */

//Solution(O(n))
class Solution
{
    int getMiddle(Node head)
    {
         // Your code here.
         if(head.next==null) return head.data;
         Node fast=head;
         Node slow=head;
         while(fast.next.next!=null && fast.next.next.next!=null){
             fast=fast.next.next;
             slow=slow.next;
         }
         return slow.next.data;
    }
}

//or
/* Function to print middle of linked list */
    void printMiddle() 
    { 
        Node slow_ptr = head; 
        Node fast_ptr = head; 
        if (head != null) 
        { 
            while (fast_ptr != null && fast_ptr.next != null) 
            { 
                fast_ptr = fast_ptr.next.next; 
                slow_ptr = slow_ptr.next; 
            } 
            System.out.println("The middle element is [" + 
                                slow_ptr.data + "] \n"); 
        } 
    } 
