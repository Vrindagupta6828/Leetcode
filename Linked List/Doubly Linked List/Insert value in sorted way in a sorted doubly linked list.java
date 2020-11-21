/* Question:
Given a sorted doubly linked list and a value to insert, write a function to insert the value in sorted way. */

//Solution
// function to insert a new node in sorted way in  
    // a sorted doubly linked list  
    static Node sortedInsert(Node head, Node newNode) 
    { 
            Node current; 
  
            // if list is empty  
            if (head == null) 
                head = newNode;  
  
            // if the node is to be inserted at the beginning  
            // of the doubly linked list  
            else if (head.data >= newNode.data) 
            { 
                newNode.next = head; 
                newNode.next.prev = newNode; 
                head = newNode; 
            } 
  
            else 
            { 
                current = head; 
  
                // locate the node after which the new node  
                // is to be inserted  
                while (current.next != null &&  
                        current.next.data < newNode.data)  
                    current = current.next; 
  
                /* Make the appropriate links */
                newNode.next = current.next; 
  
                // if the new node is not inserted  
                // at the end of the list 
                if (current.next != null)  
                    newNode.next.prev = newNode;  
  
                current.next = newNode;  
                newNode.prev = current;  
              
            } 
            return head; 
    } 
