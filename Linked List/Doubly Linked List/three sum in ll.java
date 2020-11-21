//in three sum apply an outer loop to access each element of an array and then from forward till last apply 2 sum

/* Question:
Given a sorted doubly linked list of distinct nodes(no two nodes have the same data) and a value x. Count triplets in the list that sum up to a given value x.  */

//Solution 1(O(n^3) time and O(1) space)
// function to count triplets in  
    // a sorted doubly linked list  
    // whose sum is equal to a given value 'x'  
    static int countTriplets(Node head, int x) 
    { 
            Node ptr1, ptr2, ptr3; 
            int count = 0; 
  
            // generate all possible triplets  
            for (ptr1 = head; ptr1 != null; ptr1 = ptr1.next) 
                for (ptr2 = ptr1.next; ptr2 != null; ptr2 = ptr2.next) 
                    for (ptr3 = ptr2.next; ptr3 != null; ptr3 = ptr3.next) 
  
                        // if elements in the current triplet sum up to 'x'  
                        if ((ptr1.data + ptr2.data + ptr3.data) == x) 
                              
                            // increment count 
                            count++; 
  
            // required count of triplets  
            return count; 
    } 
    
    //Solution2 ((O(n^2) time and O(N) space)
    static int countTriplets(Node head, int x) 
{ 
    Node ptr, ptr1, ptr2; 
    int count = 0; 
   
    // unordered_map 'um' implemented as hash table 
    HashMap<Integer,Node> um = new HashMap<Integer,Node>(); 
   
    // insert the <node data, node pointer> tuple in 'um' 
    for (ptr = head; ptr != null; ptr = ptr.next) 
        um.put(ptr.data, ptr); 
   
    // generate all possible pairs 
    for (ptr1 = head; ptr1 != null; ptr1 = ptr1.next) 
        for (ptr2 = ptr1.next; ptr2 != null; ptr2 = ptr2.next) { 
   
            // p_sum - sum of elements in the current pair 
            int p_sum = ptr1.data + ptr2.data; 
   
            // if 'x-p_sum' is present in 'um' and either of the two nodes 
            // are not equal to the 'um[x-p_sum]' node 
            if (um.containsKey(x - p_sum) && um.get(x - p_sum) != ptr1 
                && um.get(x - p_sum) != ptr2) 
   
                // increment count 
                count++; 
        } 
   
    // required count of triplets 
    // division by 3 as each triplet is counted 3 times 
    return (count / 3); 
} 

//Solution 3(O(n^2) time and O(1) space)
// function to count pairs whose sum equal to given 'value' 
static int countPairs(Node first, Node second, int value) 
{ 
    int count = 0; 
   
    // The loop terminates when either of two pointers 
    // become null, or they cross each other (second.next 
    // == first), or they become same (first == second) 
    while (first != null && second != null &&  
           first != second && second.next != first) { 
   
        // pair found 
        if ((first.data + second.data) == value) { 
   
            // increment count 
            count++; 
   
            // move first in forward direction 
            first = first.next; 
   
            // move second in backward direction 
            second = second.prev; 
        } 
   
        // if sum is greater than 'value' 
        // move second in backward direction 
        else if ((first.data + second.data) > value) 
            second = second.prev; 
   
        // else move first in forward direction 
        else
            first = first.next; 
    } 
   
    // required count of pairs 
    return count; 
} 
   
// function to count triplets in a sorted doubly linked list 
// whose sum is equal to a given value 'x' 
static int countTriplets(Node head, int x) 
{ 
    // if list is empty 
    if (head == null) 
        return 0; 
   
    Node current, first, last; 
    int count = 0; 
   
    // get pointer to the last node of 
    // the doubly linked list 
    last = head; 
    while (last.next != null) 
        last = last.next; 
   
    // traversing the doubly linked list 
    for (current = head; current != null; current = current.next) { 
   
        // for each current node 
        first = current.next; 
   
        // count pairs with sum(x - current.data) in the range 
        // first to last and add it to the 'count' of triplets 
        count += countPairs(first, last, x - current.data); 
    } 
   
    // required count of triplets 
    return count; 
} 
