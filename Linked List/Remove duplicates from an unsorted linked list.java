/* Question:
Write a removeDuplicates() function which takes a list and deletes any duplicate nodes from the list. The list is not sorted. 
For example if the linked list is 12->11->12->21->41->43->21 then removeDuplicates() should convert the list to 12->11->21->41->43.   */

//Solution(O(n) time and space)
  static void removeDuplicate(node head)  
    { 
        // Hash to store seen values 
        HashSet<Integer> hs = new HashSet<>(); 
      
        /* Pick elements one by one */
        node current = head; 
        node prev = null; 
        while (current != null)  
        { 
            int curval = current.val; 
              
             // If current value is seen before 
            if (hs.contains(curval)) { 
                prev.next = current.next; 
            } else { 
                hs.add(curval); 
                prev = current; 
            } 
            current = current.next; 
        } 
  
    } 
