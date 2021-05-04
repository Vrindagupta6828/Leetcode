/* Question:
Given the head of a linked list, return the list after sorting it in ascending order.

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105  */

//Solution 1(o(nlogn) time and o(n) space)
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null) return head;
        ArrayList<Integer> arr=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            arr.add(temp.val);
            temp=temp.next;
        }
        Collections.sort(arr);
        temp=head;
        int i=0;
        
        while(temp!=null){
            temp.val=arr.get(i++);
            temp=temp.next;
        }
        
        return head;
    }
}

//Solution 2
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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode mid=getMid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        return merge(left,right);
        
    }
    
    public ListNode getMid(ListNode head){
        ListNode slow=head,fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow.next;
        slow.next=null;
        return mid;
    }
    
    public ListNode merge(ListNode a,ListNode b){
        ListNode temp=new ListNode(0);
        ListNode pnt=temp;
        
        while(a!=null && b!=null){
            if(a.val<b.val){
                pnt.next=a;
                a=a.next;
            }
            else{
                pnt.next=b;
                b=b.next;
            }
            pnt=pnt.next;
        }
        pnt.next=(a!=null)?a:b;
        return temp.next;
    }
}
