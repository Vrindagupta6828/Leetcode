/ Java program to demonstrate the 
// creation of queue object using the 
// PriorityQueue class 
  
import java.util.*; 
  
class GfG { 
  
    public static void main(String args[]) 
    { 
        // Creating empty priority queue 
        Queue<Integer> pQueue 
            = new PriorityQueue<Integer>(); 
  
        // Adding items to the pQueue 
        // using add() 
        pQueue.add(10); 
        pQueue.add(20); 
        pQueue.add(15); 
  
        // Printing the top element of 
        // the PriorityQueue 
        System.out.println(pQueue.peek()); 
  
        // Printing the top element and removing it 
        // from the PriorityQueue container 
        System.out.println(pQueue.poll()); 
  
        // Printing the top element again 
        System.out.println(pQueue.peek()); 
    } 
} 
/* Output:
10
10
15  */

// Java program to demonstrate the 
// creation of queue object using the 
// LinkedList class 
  
import java.util.*; 
  
class GfG { 
  
    public static void main(String args[]) 
    { 
        // Creating empty LinkedList 
        Queue<Integer> ll 
            = new LinkedList<Integer>(); 
  
        // Adding items to the ll 
        // using add() 
        ll.add(10); 
        ll.add(20); 
        ll.add(15); 
  
        // Printing the top element of 
        // the LinkedList 
        System.out.println(ll.peek()); 
  
        // Printing the top element and removing it 
        // from the LinkedList container 
        System.out.println(ll.poll()); 
  
        // Printing the top element again 
        System.out.println(ll.peek()); 
    } 
} 
/*  Output:
10
10
20 */

// Java program to demonstrate the 
// creation of queue object using the 
// PriorityBlockingQueue class 
  
import java.util.concurrent.PriorityBlockingQueue; 
import java.util.*; 
  
class GfG { 
    public static void main(String args[]) 
    { 
        // Creating empty priority 
        // blocking queue 
        Queue<Integer> pbq 
            = new PriorityBlockingQueue<Integer>(); 
  
        // Adding items to the pbq 
        // using add() 
        pbq.add(10); 
        pbq.add(20); 
        pbq.add(15); 
  
        // Printing the top element of 
        // the PriorityBlockingQueue 
        System.out.println(pbq.peek()); 
  
        // Printing the top element and 
        // removing it from the 
        // PriorityBlockingQueue 
        System.out.println(pbq.poll()); 
  
        // Printing the top element again 
        System.out.println(pbq.peek()); 
    } 
} 

/* Output:
10
10
15  */
