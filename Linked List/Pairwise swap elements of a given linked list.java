/* Question:
Given a singly linked list, write a function to swap elements pairwise.

Input : 1->2->3->4->5->6->NULL
Output : 2->1->4->3->6->5->NULL

Input : 1->2->3->4->5->NULL
Output : 2->1->4->3->5->NULL

Input : 1->NULL
Output : 1->NULL

For example, if the linked list is 1->2->3->4->5 then the function should change it to 2->1->4->3->5, and if the linked list is then the function should change it to .   */

//Solution (O(n) time and O(1) space)\
void pairWiseSwap() 
    { 
        Node temp = head; 
  
        /* Traverse only till there are atleast 2 nodes left */
        while (temp != null && temp.next != null) { 
  
            /* Swap the data */
            int k = temp.data; 
            temp.data = temp.next.data; 
            temp.next.data = k; 
            temp = temp.next.next; 
        } 
    } 
