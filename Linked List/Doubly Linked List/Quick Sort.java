// A utility function to find last node of linked list     
    Node lastNode(Node node){ 
        while(node.next!=null) 
            node = node.next; 
        return node; 
    } 
      
  
/* Considers last element as pivot, places the pivot element at its 
   correct position in sorted array, and places all smaller (smaller than 
   pivot) to left of pivot and all greater elements to right of pivot */
    Node partition(Node l,Node h) 
    { 
       // set pivot as h element 
        int x = h.data; 
          
        // similar to i = l-1 for array implementation 
        Node i = l.prev; 
          
        // Similar to "for (int j = l; j <= h- 1; j++)" 
        for(Node j=l; j!=h; j=j.next) 
        { 
            if(j.data <= x) 
            { 
                // Similar to i++ for array 
                i = (i==null) ? l : i.next; 
                int temp = i.data; 
                i.data = j.data; 
                j.data = temp; 
            } 
        } 
        i = (i==null) ? l : i.next;  // Similar to i++ 
        int temp = i.data; 
        i.data = h.data; 
        h.data = temp; 
        return i; 
    } 
      
    /* A recursive implementation of quicksort for linked list */
    void _quickSort(Node l,Node h) 
    { 
        if(h!=null && l!=h && l!=h.next){ 
            Node temp = partition(l,h); 
            _quickSort(l,temp.prev); 
            _quickSort(temp.next,h); 
        } 
    } 
      
    // The main function to sort a linked list. It mainly calls _quickSort() 
    public void quickSort(Node node) 
    { 
        // Find last node 
        Node head = lastNode(node); 
          
        // Call the recursive QuickSort 
        _quickSort(node,head); 
    } 
