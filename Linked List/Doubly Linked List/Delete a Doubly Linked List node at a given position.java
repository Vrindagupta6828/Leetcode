/* Question:
Given a doubly linked list and a position n. The task is to delete the node at the given position n from the beginning.  */

//Solution
 // Function to delete a node 
    // in a Doubly Linked List.
    // head_ref --> pointer to head node pointer.
    // del --> pointer to node to be deleted.
    static Node deleteNode(Node del)
    {
        // base case
        if (head == null || del == null)
            return null;
 
        // If node to be deleted is head node
        if (head == del)
            head = del.next;
 
        // Change next only if node to be 
        // deleted is NOT the last node
        if (del.next != null)
            del.next.prev = del.prev;
 
        // Change prev only if node to be 
        // deleted is NOT the first node
        if (del.prev != null)
            del.prev.next = del.next;
 
        del = null;
 
        return head;
    }
 
    // Function to delete the node at the
    // given position in the doubly linked list
    static void deleteNodeAtGivenPos(int n)
    {
        /* if list in NULL or 
          invalid position is given */
        if (head == null || n <= 0)
            return;
 
        Node current = head;
        int i;
 
        /*
        * traverse up to the node at 
          position 'n' from the beginning
        */
        for (i = 1; current != null && i < n; i++)
        {
            current = current.next;
        }
         
        // if 'n' is greater than the number of nodes
        // in the doubly linked list
        if (current == null)
            return;
 
        // delete the node pointed to by 'current'
        deleteNode(current);
    }
 
