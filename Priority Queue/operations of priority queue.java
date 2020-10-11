/Adding elements
// Java program to add elements 
// to a PriorityQueue 
import java.util.*; 
import java.io.*; 
  
public class PriorityQueueDemo { 
  
    public static void main(String args[]) 
    { 
        PriorityQueue<String> pq = new PriorityQueue<>(); 
  
        pq.add("Geeks"); 
        pq.add("For"); 
        pq.add("Geeks"); 
  
        System.out.println(pq); 
    } 
}
/*
Output:

[For, Geeks, Geeks]  */

//Removing elements

// Java program to remove elements 
// from a PriorityQueue 
  
import java.util.*; 
import java.io.*; 
  
public class PriorityQueueDemo { 
  
    public static void main(String args[]) 
    { 
        PriorityQueue<String> pq = new PriorityQueue<>(); 
  
        pq.add("Geeks"); 
        pq.add("For"); 
        pq.add("Geeks"); 
  
        System.out.println("Initial PriorityQueue " + pq); 
  
          // using the method 
        pq.remove("Geeks"); 
  
        System.out.println("After Remove - " + pq); 
  
        System.out.println("Poll Method - " + pq.poll()); 
  
        System.out.println("Final PriorityQueue - " + pq); 
    } 
}
/*Output:

Initial PriorityQueue [For, Geeks, Geeks]
After Remove - [For, Geeks]
Poll Method - For
Final PriorityQueue - [Geeks] */

//Accessing 
// Java program to access elements 
// from a PriorityQueue 
import java.util.*; 
  
class PriorityQueueDemo { 
    
      // Main Method 
    public static void main(String[] args) 
    { 
  
        // Creating a priority queue 
        PriorityQueue<String> pq = new PriorityQueue<>(); 
        pq.add("Geeks"); 
        pq.add("For"); 
        pq.add("Geeks"); 
        System.out.println("PriorityQueue: " + pq); 
  
        // Using the peek() method 
        String element = pq.peek(); 
        System.out.println("Accessed Element: " + element); 
    } 
}
/* Output:

PriorityQueue: [For, Geeks, Geeks]
Accessed Element: For */

//iterate 
// Java program to iterate elements 
// to a PriorityQueue 
  
import java.util.*; 
  
public class PriorityQueueDemo { 
  
      // Main Method 
    public static void main(String args[]) 
    { 
        PriorityQueue<String> pq = new PriorityQueue<>(); 
  
        pq.add("Geeks"); 
        pq.add("For"); 
        pq.add("Geeks"); 
  
        Iterator iterator = pq.iterator(); 
  
        while (iterator.hasNext()) { 
            System.out.print(iterator.next() + " "); 
        } 
    } 
}

/* Output:

For Geeks Geeks */
