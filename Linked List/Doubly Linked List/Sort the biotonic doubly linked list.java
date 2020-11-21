/* Question:
Sort the given biotonic doubly linked list. A biotonic doubly linked
list is a doubly linked list which is first increasing and then decreasing. A strictly increasing or a strictly decreasing list is also a biotonic doubly linked list.  */

//Solution
// Function to reverse a Doubly Linked List 
static Node reverse( Node head_ref) 
{ 
    Node temp = null; 
    Node current = head_ref; 
  
    // swap next and prev for all nodes 
    // of doubly linked list 
    while (current != null) 
    { 
        temp = current.prev; 
        current.prev = current.next; 
        current.next = temp; 
        current = current.prev; 
    } 
  
    // Before changing head, check for the cases  
    // like empty list and list with only one node 
    if (temp != null) 
        head_ref = temp.prev; 
        return head_ref; 
} 
  
// Function to merge two sorted doubly linked lists 
static Node merge(Node first, Node second) 
{ 
    // If first linked list is empty 
    if (first == null) 
        return second; 
  
    // If second linked list is empty 
    if (second == null) 
        return first; 
  
    // Pick the smaller value 
    if (first.data < second.data) 
    { 
        first.next = merge(first.next, second); 
        first.next.prev = first; 
        first.prev = null; 
        return first; 
    }  
    else 
    { 
        second.next = merge(first, second.next); 
        second.next.prev = second; 
        second.prev = null; 
        return second; 
    } 
} 
  
// function to sort a biotonic doubly linked list 
static Node sort(Node head) 
{ 
    // if list is empty or if it contains  
    // a single node only 
    if (head == null || head.next == null) 
        return head; 
  
    Node current = head.next; 
  
    while (current != null)  
    { 
  
        // if true, then 'current' is the first node 
        // which is smaller than its previous node 
        if (current.data < current.prev.data) 
            break; 
  
        // move to the next node 
        current = current.next; 
    } 
  
    // if true, then list is already sorted 
    if (current == null) 
        return head; 
  
    // spilt into two lists, one starting with 'head' 
    // and other starting with 'current' 
    current.prev.next = null; 
    current.prev = null; 
  
    // reverse the list starting with 'current' 
    current = reverse(current); 
  
    // merge the two lists and return the 
    // final merged doubly linked list 
    return merge(head, current); 
} 
