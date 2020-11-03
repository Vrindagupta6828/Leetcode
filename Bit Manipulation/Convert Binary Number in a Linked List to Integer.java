/* Question:
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

 

Example 1:


Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10
Example 2:

Input: head = [0]
Output: 0
Example 3:

Input: head = [1]
Output: 1
Example 4:

Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
Output: 18880
Example 5:

Input: head = [0,0]
Output: 0

Constraints:

The Linked List is not empty.
Number of nodes will not exceed 30.
Each node's value is either 0 or 1.   */

//Solution 1(o(n) time and space)
class Solution {
    public int getDecimalValue(ListNode head) {
        StringBuilder sb=new StringBuilder();
        ListNode p=head;
        while(p!=null){
            sb.append(p.val);
            p=p.next;
        }
        int result=0;
        for(int i=sb.length()-1;i>=0;i--){
            result+=(int)Math.pow(2,sb.length()-1-i)*(sb.charAt(i)-'0');
        }
        return result;
    }
}

//Solution 2(o(n) time and o(1) space)
class Solution {
    public int getDecimalValue(ListNode head) {
        int num=head.val;
        while(head.next!=null){
            num=num*2+head.next.val;
            head=head.next;
        }
        return num;
    }
}

//Solution 3 (o(n) time and o(1) space)
class Solution {
    public int getDecimalValue(ListNode head) {
        int num=head.val;
        while(head.next!=null){
            num=(num<<1)|head.next.val;
            head=head.next;
        }
        return num;
    }
}


