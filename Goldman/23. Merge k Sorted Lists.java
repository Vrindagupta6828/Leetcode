/* Question:
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.  */

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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> q=new PriorityQueue<>();
        int n=lists.length;
        for(int i=0;i<n;i++){
            ListNode temp=lists[i];
            while(temp!=null){
              q.add(temp.val);
              temp=temp.next;}
        }
        
        ListNode head=new ListNode(0);
        ListNode curr=head;
        while(!q.isEmpty()){
            curr.next=new ListNode(q.poll());
            curr=curr.next;
        }
        return head.next;
    }
}

//Solution 2
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null; // no result yet
        
        // merge lists one by one
        for(int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            
            // merge current list with the prevuous result
            result = mergeTwoLists(result, list);
        }
        
        return result;
    }
    
    private ListNode mergeTwoLists(ListNode first, ListNode second) {
        ListNode root = new ListNode();
        ListNode node = root;
        
        // start pointers from both list
        ListNode pointer1 = first;
        ListNode pointer2 = second;
        
        // traverse both list and add to the result list the lowest value
        while(pointer1 != null && pointer2 != null) {
            int val1 = pointer1.val;
            int val2 = pointer2.val;
            
            if(val1 <= val2) {
                // if first value is lower than second (or equal) add it to the result and move first pointer to the next element
                node.next = pointer1;
                pointer1 = pointer1.next;
            } else if( val2 < val1) {
                // if second value is lower than first one
                node.next = pointer2;
                pointer2 = pointer2.next;
            }
            
            // we've added this node iterate to the next
            node = node.next;
        }
        
        // if we still have something from first pointer
        if(pointer1 != null) {
            node.next = pointer1;
        }
        
        // if we still have something from second pointer
        if(pointer2 != null) {
            node.next = pointer2;
        }
        
        return root.next;
    }
}

//Solution 3
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
    public ListNode mergeKLists(ListNode[] lists) {
  return divide(lists, 0, lists.length - 1);
}

private ListNode divide(ListNode[] lists, int start, int end) {
  if (start == end) {
    return lists[start];
  } else if (start < end){
    int mid = (end - start) / 2 + start;
    ListNode left = divide(lists, start, mid);
    ListNode right = divide(lists, mid + 1, end);
    return mergeSort(left, right);
  } else {
    return null;
  }
}

private static ListNode mergeSort(ListNode a, ListNode b) {
  ListNode dummy = new ListNode(0);
  ListNode tail = dummy;
  while (a != null && b != null) {
    if (a.val < b.val) {
      tail.next = a;
      a = a.next;
    } else {
      tail.next = b;
      b = b.next;
    }
    tail = tail.next;
  }

  if (a != null) {
    tail.next = a;
  } else {
    tail.next = b;
  }

  return dummy.next;
}
}
