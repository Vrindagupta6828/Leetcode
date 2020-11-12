/* Question:
 
Given pointer to the head node of a linked list, the task is to reverse the linked list. We need to reverse the list by changing the links between nodes.

Examples: 

Input: Head of following linked list 
1->2->3->4->NULL 
Output: Linked list should be changed to, 
4->3->2->1->NULL

Input: Head of following linked list 
1->2->3->4->5->NULL 
Output: Linked list should be changed to, 
5->4->3->2->1->NULL

Input: NULL 
Output: NULL  */

//Solution 1 (O(n) time and O(1) space)
class ReverseLL
{
    // This function should reverse linked list and return
    // head of the modified linked list.
    Node reverseList(Node head)
    {
        // code here
        if(head==null || head.next==null) return head;
        Node ptr=head,prev=null;
        while(ptr!=null){
            Node temp=ptr.next;
            ptr.next=prev;
            prev=ptr;
            ptr=temp;
        }
        head=prev;
        return head;
    }
}
