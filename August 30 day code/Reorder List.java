/* Problem:
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.   */

//Solution

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

/**

********************** <EXPLAINATION> **********************

Time complexity: O(N)
 
The idea is simple: SPLIT -> REVERSE -> MERGE

Step 1: SPLIT

    We split our 1 list into 2 halves
    
    Example
            We take:
            0 -> 1 -> 2 -> 3 -> 4 -> 5
            
            and it becomes:
            0 -> 1 -> 2
            3 -> 4 -> 5

Step 2: REVERSE

    We now reverse our second list
    
    Example:   
            We take:
            0 -> 1 -> 2
            3 -> 4 -> 5

            and it becomes:
            0 -> 1 -> 2
            5 -> 4 -> 3
    
Step 3: MERGE
    
    Finally we merge our 2 lists
    
    Example:
            We take:
            0 -> 1 -> 2
            5 -> 4 -> 3
            
            and it becomes:
            0 -> 5 -> 1 -> 4 -> 2 -> 3

********************** </EXPLAINATION> **********************

**/

class Solution {
    public void reorderList(ListNode head) {
        
        //  edge cases
        if(head==null||head.next==null){
            return;
        }
        
        //  STEP 1: SPLIT
        ListNode l1 = head;
        ListNode l2 = head;
        while(l2.next!=null&&l2.next.next!=null){
            l1 = l1.next;
            l2 = l2.next.next;
        }
        l2 = l1.next;
        l1 = head;
        
        //  STEP 2: REVERSE
        ListNode l2Curr = l2;
        ListNode prev = null;
        ListNode next = null;
        while(l2Curr!=null){
            next = l2Curr.next;
            l2Curr.next = prev;
            prev = l2Curr;
            l2Curr = next;
        }
        l2 = prev;
        
        
        //  Step 3: MERGE
        ListNode curr = head;
        ListNode l1Curr = l1;
        l2Curr = l2;
        for(boolean b=true;;b=!b){
            next = curr.next;
            if(b){
                curr.next = l2Curr;
                if(l2Curr==null)break;
                l1Curr = next;
            }else{
                curr.next = l1Curr;
                if(l1Curr==null)break;
                l2Curr = next;
            }
            curr = curr.next;
        }
    }
}
