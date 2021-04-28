/* Question:
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:


Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
 

Constraints:

The number of nodes in the linked list is in the range [0, 104].
-106 <= Node.val <= 106  */


//Solution 1 (o(n) time and space)
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
    public ListNode oddEvenList(ListNode head) {
        ArrayList<Integer> odd=new ArrayList<>();
        ArrayList<Integer> even=new ArrayList<>();
        
        ListNode temp=head;
        while(temp!=null){
           odd.add(temp.val);
           if(temp.next!=null)
           {   even.add(temp.next.val);
               temp=temp.next.next;}
           else break;
        }

        temp=head;
        for(int i:odd){
            temp.val=i;
            temp=temp.next;
        }
        
        for(int i:even){
            temp.val=i;
            temp=temp.next;
        }
        return head;
    }
}

//Solution 2(o(n) time and space)
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode ans=new ListNode(0);
        ListNode temp=ans;
        ListNode pnt=head;
        
        while(pnt!=null){
            temp.next=new ListNode(pnt.val);
            temp=temp.next;
            if(pnt.next!=null) pnt=pnt.next.next;
            else break;
        }
        
        pnt=head.next;
        while(pnt!=null){
            temp.next=new ListNode(pnt.val);
            temp=temp.next;
            if(pnt.next!=null) pnt=pnt.next.next;
            else break;
        }
        return ans.next;
    }
}

//Solution 3(o(n) time and o(1) space)
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
