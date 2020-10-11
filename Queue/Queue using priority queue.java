import java.util.*; 
  
public class GFG { 
  
    public static void main(String args[]) 
    { 
        Queue<String> pq = new PriorityQueue<>(); 
  
        pq.add("Geeks"); 
        pq.add("For"); 
        pq.add("Geeks"); 
  
        System.out.println(pq); 
    } 
} 


//Output:
//[For, Geeks, Geeks]

//Deleting
// Java program to remove elements 
// from a Queue 
  
import java.util.*; 
  
public class GFG { 
  
    public static void main(String args[]) 
    { 
        Queue<String> pq = new PriorityQueue<>(); 
  
        pq.add("Geeks"); 
        pq.add("For"); 
        pq.add("Geeks"); 
  
        System.out.println("Initial Queue " + pq); 
  
        pq.remove("Geeks"); 
  
        System.out.println("After Remove " + pq); 
  
        System.out.println("Poll Method " + pq.poll()); 
  
        System.out.println("Final Queue " + pq); 
    } 
} 

/* Output:
Initial Queue [For, Geeks, Geeks]
After Remove [For, Geeks]
Poll Method For
Final Queue [Geeks] */

//Iteration (can be converted to array or use it's inbuilt iterator)
// Java program to iterate elements 
// to a Queue 
  
import java.util.*; 
  
public class GFG { 
  
    public static void main(String args[]) 
    { 
        Queue<String> pq = new PriorityQueue<>(); 
  
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

