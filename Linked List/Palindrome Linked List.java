/* Question:
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?  */

//Solution 1(O(n) time & space)
class Solution {
    public boolean isPalindrome(ListNode head) {
       Stack<Integer> reverse=new Stack<>();
       ListNode temp=head,fast=head;
       while(fast!=null && fast.next!=null){
           reverse.push(temp.val);
           temp=temp.next;
           fast=fast.next.next;
       }
        if (fast!=null) temp=temp.next;
       while(temp!=null){
           if(temp.val!=reverse.pop())
               return false;
           temp=temp.next;
       }
        return true;
    }
}

//Solution 2(O(n) & O(1) space)
public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode fast = head, slow = head;

        /** find middle element */
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        /** reverse the second half */
        ListNode prev = null;
        while(slow != null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        /** compare the first and second half if odd no. of elements then middle element is checked with itself*/
        slow = prev;
        while(slow != null) {
            if(head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
