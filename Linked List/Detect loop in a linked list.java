/* Question:
Given a linked list, check if the linked list has loop or not. */

//Solution 1 (O(n) time and O(1) space) (Floyd’s Cycle-Finding Algorithm )
class Solution {
    public static boolean detectLoop(Node head){
        // Add code here
        if(head!=null || head.next!=null){
        Node fast=head.next;
        Node slow=head;
        while(fast!=slow){
            if(fast==null || fast.next==null)
               return false;
            fast=fast.next.next;
            slow=slow.next;
        }
        return true;
    }
    return false;
}}

//Solution 2(O(n) space & time)
 static boolean detectLoop(Node h) 
    { 
        HashSet<Node> s = new HashSet<Node>(); 
        while (h != null) { 
            // If we have already has this node 
            // in hashmap it means their is a cycle 
            // (Because you we encountering the 
            // node second time). 
            if (s.contains(h)) 
                return true; 
  
            // If we are seeing the node for 
            // the first time, insert it in hash 
            s.add(h); 
  
            h = h.next; 
        } 
  
        return false; 
    }
    
    //Solution 3(O(n) time and O(1) space)
    
    /*In this method, a temporary node is created. The next pointer of each node that is traversed is made to point to this temporary node. 
    This way we are using the next pointer of a node as a flag to indicate whether the node has been traversed or not. Every node is checked 
    to see if the next is pointing to a temporary node or not. In the case of the first node of the loop, the second time we traverse it this 
    condition will be true, hence we find that loop exists. If we come across a node that points to null then loop doesn’t exist.
    Below is the implementation of the above approach: */
    
    static boolean detectLoop(Node head) 
    { 
  
        // Create a temporary node 
        Node temp = new Node(); 
        while (head != null) { 
  
            // This condition is for the case 
            // when there is no loop 
            if (head.next == null) { 
                return false; 
            } 
  
            // Check if next is already 
            // pointing to temp 
            if (head.next == temp) { 
                return true; 
            } 
  
            // Store the pointer to the next node 
            // in order to get to it in the next step 
            Node nex = head.next; 
  
            // Make next point to temp 
            head.next = temp; 
  
            // Get to the next node in the list 
            head = nex; 
        } 
  
        return false; 
    } 
