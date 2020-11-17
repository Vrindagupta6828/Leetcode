/* Question:
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3  */

//Solution(O(n) time and O(1) space)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy=new ListNode(head.val);head=head.next;
        ListNode curr=dummy;
        while(head!=null){
            if (dummy.val!=head.val)
            {dummy.next=head;dummy=dummy.next;}
            head=head.next;
        }
        dummy.next=null;
        return curr;
    }
}

//Solution 2
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr=head;
        while(curr !=null && curr.next!=null){
            if (curr.next.val==curr.val)
              curr.next=curr.next.next;
            else curr=curr.next;
        }
        return head;
    }
}
