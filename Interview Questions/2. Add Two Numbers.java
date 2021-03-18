/* Question:
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.  */

//Solution:
 /* public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode temp=new ListNode(0);
        ListNode curr=temp;
        ListNode head1=l1,head2=l2;
        
        while(head1!=null && head2!=null){
            curr.next=new ListNode((head1.val+head2.val+carry)%10);
            carry=(head1.val+head2.val+carry)/10;
            curr=curr.next;
            head1=head1.next;
            head2=head2.next;
        }
        
        while(head1!=null){
            curr.next=new ListNode((head1.val+carry)%10);
            carry=(head1.val+carry)/10;
            curr=curr.next;
            head1=head1.next;
        }
        
        while(head2!=null){
            curr.next=new ListNode((head2.val+carry)%10);
            carry=(head2.val+carry)/10;
            curr=curr.next;
            head2=head2.next;
        }
        
        if(carry!=0){
            curr.next=new ListNode(carry);
            curr=curr.next;
        }
    
        return temp.next;
    }
}
