/* Question:
Given a stream of characters, find the first non-repeating character from stream. You need to tell the first non-repeating character in O(1) time at any moment.   */

//Solution(use double linked list)
/ A Java program to find first non-repeating character 
// from a stream of characters 
  
import java.util.ArrayList; 
import java.util.List; 
  
public class NonReapeatingC { 
    final static int MAX_CHAR = 256; 
  
    static void findFirstNonRepeating() 
    { 
        // inDLL[x] contains pointer to a DLL node if x is present 
        // in DLL. If x is not present, then inDLL[x] is NULL 
        List<Character> inDLL = new ArrayList<Character>(); 
  
        // repeated[x] is true if x is repeated two or more times. 
        // If x is not seen so far or x is seen only once. then 
        // repeated[x] is false 
        boolean[] repeated = new boolean[MAX_CHAR]; 
  
        // Let us consider following stream and see the process 
        String stream = "geeksforgeeksandgeeksquizfor"; 
        for (int i = 0; i < stream.length(); i++) { 
            char x = stream.charAt(i); 
            System.out.println("Reading " + x + " from stream n"); 
  
            // We process this character only if it has not occurred 
            // or occurred only once. repeated[x] is true if x is 
            // repeated twice or more.s 
            if (!repeated[x]) { 
                // If the character is not in DLL, then add this at 
                // the end of DLL. 
                if (!(inDLL.contains(x))) { 
                    inDLL.add(x); 
                } 
                else // Otherwise remove this character from DLL 
                { 
                    inDLL.remove((Character)x); 
                    repeated[x] = true; // Also mark it as repeated 
                } 
            } 
  
            // Print the current first non-repeating character from 
            // stream 
            if (inDLL.size() != 0) { 
                System.out.print("First non-repeating character so far is "); 
                System.out.println(inDLL.get(0)); 
            } 
        } 
    } 
  
    /* Driver program to test above function */
    public static void main(String[] args) 
    { 
        findFirstNonRepeating(); 
    } 
} 


/* Output:
Reading g from stream
First non-repeating character so far is g
Reading e from stream
First non-repeating character so far is g
Reading e from stream
First non-repeating character so far is g
Reading k from stream
First non-repeating character so far is g
Reading s from stream
First non-repeating character so far is g
Reading f from stream
First non-repeating character so far is g
Reading o from stream
First non-repeating character so far is g
Reading r from stream
First non-repeating character so far is g
Reading g from stream
First non-repeating character so far is k
Reading e from stream
First non-repeating character so far is k
Reading e from stream
First non-repeating character so far is k
Reading k from stream
First non-repeating character so far is s
Reading s from stream
First non-repeating character so far is f
Reading a from stream
First non-repeating character so far is f
Reading n from stream
First non-repeating character so far is f
Reading d from stream
First non-repeating character so far is f
Reading g from stream
First non-repeating character so far is f
Reading e from stream
First non-repeating character so far is f
Reading e from stream
First non-repeating character so far is f
Reading k from stream
First non-repeating character so far is f
Reading s from stream
First non-repeating character so far is f
Reading q from stream
First non-repeating character so far is f
Reading u from stream
First non-repeating character so far is f
Reading i from stream
First non-repeating character so far is f
Reading z from stream
First non-repeating character so far is f
Reading f from stream
First non-repeating character so far is o
Reading o from stream
First non-repeating character so far is r
Reading r from stream
First non-repeating character so far is a  */
