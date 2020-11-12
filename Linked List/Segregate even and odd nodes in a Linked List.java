/* Question:
Given a Linked List of integers, write a function to modify the linked list such that all even numbers appear before all the odd numbers in the modified linked list. Also, keep the order of even and odd numbers same.

Examples:

Input: 17->15->8->12->10->5->4->1->7->6->NULL
Output: 8->12->10->4->6->17->15->5->1->7->NULL

Input: 8->12->10->5->4->1->6->NULL
Output: 8->12->10->4->6->5->1->NULL

// If all numbers are even then do not change the list
Input: 8->12->10->NULL
Output: 8->12->10->NULL

// If all numbers are odd then do not change the list
Input: 1->3->5->7->NULL
Output: 1->3->5->7->NULL  */

//Solution
// Java program to segregate even and odd nodes in a 
// Linked List 
import java.io.*; 
  
class LinkedList { 
      
    Node head;  // head of list 
   
    /* Linked list Node*/
    class Node 
    { 
        int data; 
        Node next; 
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
      
    public void segregateEvenOdd() { 
          
        Node evenStart = null; 
        Node evenEnd = null; 
        Node oddStart = null; 
        Node oddEnd = null; 
        Node currentNode = head; 
          
        while(currentNode != null) { 
            int element = currentNode.data; 
              
            if(element % 2 == 0) { 
                  
                if(evenStart == null) { 
                    evenStart = currentNode; 
                    evenEnd = evenStart; 
                } else { 
                    evenEnd.next = currentNode; 
                    evenEnd = evenEnd.next; 
                } 
                  
            } else { 
                  
                if(oddStart == null) { 
                    oddStart = currentNode; 
                    oddEnd = oddStart; 
                } else { 
                    oddEnd.next = currentNode; 
                    oddEnd = oddEnd.next; 
                } 
            } 
                        // Move head pointer one step in forward direction 
            currentNode = currentNode.next;     
        } 
          
          
        if(oddStart == null || evenStart == null) { 
            return; 
        } 
          
        evenEnd.next = oddStart; 
        oddEnd.next = null; 
        head=evenStart; 
    } 
      
    /*  Given a reference (pointer to pointer) to the head 
        of a list and an int, push a new node on the front 
        of the list. */
    void push(int new_data) 
    { 
        /* 1 & 2: Allocate the Node & 
                  Put in the data*/
        Node new_node = new Node(new_data); 
   
        /* 3. Make next of new Node as head */
        new_node.next = head; 
   
        /* 4. Move the head to point to new Node */
        head = new_node; 
    } 
   
    // Utility function to print a linked list 
    void printList() 
    { 
        Node temp = head; 
        while(temp != null) 
        { 
            System.out.print(temp.data+" "); 
            temp = temp.next; 
        } 
        System.out.println(); 
    } 
      
    /* Driver program to test above functions */
    public static void main(String args[]) 
    { 
        LinkedList llist = new LinkedList(); 
        llist.push(11); 
        llist.push(10); 
        llist.push(9); 
        llist.push(6); 
        llist.push(4); 
        llist.push(1); 
        llist.push(0); 
        System.out.println("Origional Linked List"); 
        llist.printList(); 
   
        llist.segregateEvenOdd(); 
   
        System.out.println("Modified Linked List"); 
        llist.printList(); 
    } 
} 

/*
Output:
Origional Linked List
0 1 4 6 9 10 11 
Modified Linked List
0 4 6 10 1 9 11  */
