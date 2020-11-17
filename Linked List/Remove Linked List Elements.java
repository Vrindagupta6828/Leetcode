/* Question:
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5  */

//Solution 1(O(n) time and O(1) space)
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr=head,prev=null;
        while(curr!=null){
            if(curr.val==val){
                if(curr==head) head=head.next;
                else prev.next=curr.next;
            }
            else  prev=curr;
            curr=curr.next;
        }
        return head;
}}
