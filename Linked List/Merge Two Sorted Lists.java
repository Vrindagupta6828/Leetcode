/* Question:
Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

 

Example 1:


Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order. */

//Solution 1(using dummy node)(O(m+n) time and O(1) space)
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummy=new ListNode(0);
        ListNode temp1=l1,temp2=l2,curr=dummy;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                dummy.next=temp1;
                temp1=temp1.next;
            }
            else { 
                dummy.next=temp2;
                temp2=temp2.next;
            }
            dummy=dummy.next;
        }
        
        while(temp2!=null) {dummy.next=temp2;temp2=temp2.next;dummy=dummy.next;}
        while(temp1!=null) {dummy.next=temp1;temp1=temp1.next;dummy=dummy.next;}
        return curr.next;
     }
}

//Solution 2(O(n+m) time and O(1) space)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<=l2.val) return merge(l1,l2);
        else return merge(l2,l1);
    }
    
    private ListNode merge(ListNode l1,ListNode l2){
        ListNode temp1=l1,temp2=l2,prev=l1;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                prev=temp1;
                temp1=temp1.next;
            }
            else { ListNode p=temp2.next;
                   temp2.next=temp1;
                   prev.next=temp2;
                   prev=temp2;
                   temp2=p;
                 }
        }
        if(temp2!=null) prev.next=temp2;
        return l1;
     }
}
