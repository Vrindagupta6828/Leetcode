/* Question:
Given a singly linked list, swap kth node from beginning with kth node from end. Swapping of data is not allowed, only pointers should be changed.   */

//Solution(O(n) time and O(1) space)

/* Utility function for calculating  
       length of linked list */
    int countNodes() 
    { 
        int count = 0; 
        Node s = head; 
        while (s != null) { 
            count++; 
            s = s.next; 
        } 
        return count; 
    } 
  
    /* Function for swapping kth nodes from  
       both ends of linked list */
    void swapKth(int k) 
    { 
        // Count nodes in linked list 
        int n = countNodes(); 
  
        // Check if k is valid 
        if (n < k) 
            return; 
  
        // If x (kth node from start) and 
        // y(kth node from end) are same 
        if (2 * k - 1 == n) 
            return; 
  
        // Find the kth node from beginning of linked list. 
        // We also find previous of kth node because we need 
        // to update next pointer of the previous. 
        Node x = head; 
        Node x_prev = null; 
        for (int i = 1; i < k; i++) { 
            x_prev = x; 
            x = x.next; 
        } 
  
        // Similarly, find the kth node from end and its 
        // previous. kth node from end is (n-k+1)th node 
        // from beginning 
        Node y = head; 
        Node y_prev = null; 
        for (int i = 1; i < n - k + 1; i++) { 
            y_prev = y; 
            y = y.next; 
        } 
  
        // If x_prev exists, then new next of it will be y. 
        // Consider the case when y->next is x, in this case, 
        // x_prev and y are same. So the statement 
        // "x_prev->next = y" creates a self loop. This self 
        // loop will be broken when we change y->next. 
        if (x_prev != null) 
            x_prev.next = y; 
  
        // Same thing applies to y_prev 
        if (y_prev != null) 
            y_prev.next = x; 
  
        // Swap next pointers of x and y. These statements 
        // also break self loop if x->next is y or y->next 
        // is x 
        Node temp = x.next; 
        x.next = y.next; 
        y.next = temp; 
  
        // Change head pointers when k is 1 or n 
        if (k == 1) 
            head = y; 
  
        if (k == n) 
            head = x; 
    } 
  
