/* Question:
Given a Linked List and a number n, write a function that returns the value at the n’th node from the end of the Linked List.(last node is 1) */

//Solution 1 O(n)

// Simple Java program to find n'th node from end of linked list 
class LinkedList { 
    Node head; // head of the list 
  
    /* Linked List node */
    class Node { 
        int data; 
        Node next; 
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
  
    /* Function to get the nth node from the last of a 
       linked list */
    void printNthFromLast(int n) 
    { 
        int len = 0; 
        Node temp = head; 
  
        // 1) count the number of nodes in Linked List 
        while (temp != null) { 
            temp = temp.next; 
            len++; 
        } 
  
        // check if value of n is not more than length of 
        // the linked list 
        if (len < n) 
            return; 
  
        temp = head; 
  
        // 2) get the (len-n+1)th node from the beginning 
        for (int i = 1; i < len - n + 1; i++) 
            temp = temp.next; 
  
        System.out.println(temp.data); 
    } 
  
    /* Inserts a new Node at front of the list. */
    public void push(int new_data) 
    { 
        /* 1 & 2: Allocate the Node & 
                  Put in the data*/
        Node new_node = new Node(new_data); 
  
        /* 3. Make next of new Node as head */
        new_node.next = head; 
  
        /* 4. Move the head to point to new Node */
        head = new_node; 
    } 
  
    /*Driver program to test above methods */
    public static void main(String[] args) 
    { 
        LinkedList llist = new LinkedList(); 
        llist.push(20); 
        llist.push(4); 
        llist.push(15); 
        llist.push(35); 
  
        llist.printNthFromLast(4); 
    } 
} 

//Solution 2 O(n)
// Java program to find n'th  
// node from end using slow and 
// fast pointers 
class LinkedList  
{ 
    Node head; // head of the list 
  
    /* Linked List node */
    class Node { 
        int data; 
        Node next; 
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
  
    /* Function to get the  
      nth node from end of list */
    void printNthFromLast(int n) 
    { 
        Node main_ptr = head; 
        Node ref_ptr = head; 
  
        int count = 0; 
        if (head != null)  
        { 
            while (count < n)  
            { 
                if (ref_ptr == null)  
                { 
                    System.out.println(n  
                     + " is greater than the no "
                       + " of nodes in the list"); 
                    return; 
                } 
                ref_ptr = ref_ptr.next; 
                count++; 
            } 
  
            if(ref_ptr == null) 
            { 
              head = head.next; 
              if(head != null) 
                System.out.println("Node no. " + n + 
                                   " from last is " +  
                                      head.data); 
            } 
            else
            { 
                    
              while (ref_ptr != null)  
              { 
                  main_ptr = main_ptr.next; 
                  ref_ptr = ref_ptr.next; 
              } 
              System.out.println("Node no. " + n + 
                                " from last is " + 
                                  main_ptr.data); 
            } 
        } 
    } 
  
    /* Inserts a new Node at front of the list. */
    public void push(int new_data) 
    { 
        /* 1 & 2: Allocate the Node & 
                  Put in the data*/
        Node new_node = new Node(new_data); 
  
        /* 3. Make next of new Node as head */
        new_node.next = head; 
  
        /* 4. Move the head to point to new Node */
        head = new_node; 
    } 
  
    /*Driver program to test above methods */
    public static void main(String[] args) 
    { 
        LinkedList llist = new LinkedList(); 
        llist.push(20); 
        llist.push(4); 
        llist.push(15); 
        llist.push(35); 
  
        llist.printNthFromLast(4); 
    } 
}  // Java program to find n'th  
// node from end using slow and 
// fast pointers 
class LinkedList  
{ 
    Node head; // head of the list 
  
    /* Linked List node */
    class Node { 
        int data; 
        Node next; 
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
  
    /* Function to get the  
      nth node from end of list */
    void printNthFromLast(int n) 
    { 
        Node main_ptr = head; 
        Node ref_ptr = head; 
  
        int count = 0; 
        if (head != null)  
        { 
            while (count < n)  
            { 
                if (ref_ptr == null)  
                { 
                    System.out.println(n  
                     + " is greater than the no "
                       + " of nodes in the list"); 
                    return; 
                } 
                ref_ptr = ref_ptr.next; 
                count++; 
            } 
  
            if(ref_ptr == null) 
            { 
              head = head.next; 
              if(head != null) 
                System.out.println("Node no. " + n + 
                                   " from last is " +  
                                      head.data); 
            } 
            else
            { 
                    
              while (ref_ptr != null)  
              { 
                  main_ptr = main_ptr.next; 
                  ref_ptr = ref_ptr.next; 
              } 
              System.out.println("Node no. " + n + 
                                " from last is " + 
                                  main_ptr.data); 
            } 
        } 
    } 
  
    /* Inserts a new Node at front of the list. */
    public void push(int new_data) 
    { 
        /* 1 & 2: Allocate the Node & 
                  Put in the data*/
        Node new_node = new Node(new_data); 
  
        /* 3. Make next of new Node as head */
        new_node.next = head; 
  
        /* 4. Move the head to point to new Node */
        head = new_node; 
    } 
  
    /*Driver program to test above methods */
    public static void main(String[] args) 
    { 
        LinkedList llist = new LinkedList(); 
        llist.push(20); 
        llist.push(4); 
        llist.push(15); 
        llist.push(35); 
  
        llist.printNthFromLast(4); 
    } 
}  
