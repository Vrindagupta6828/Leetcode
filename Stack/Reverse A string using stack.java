//Question: Given a string, reverse it using stack. For example “GeeksQuiz” should be converted to “ziuQskeeG”.

//Solution 1(with stack o(n) time and space)
/* Java program to reverse  
String using Stack */
      
import java.util.*; 
  
//stack 
class Stack 
{ 
    int size; 
    int top; 
    char[] a;  
  
    //function to check if stack is empty 
    boolean isEmpty() 
    { 
        return (top < 0); 
    } 
      
    Stack(int n) 
    { 
        top = -1; 
        size = n; 
        a = new char[size]; 
    } 
  
    //function to push element in Stack 
    boolean push(char x) 
    { 
        if (top >= size) 
        { 
        System.out.println("Stack Overflow"); 
        return false; 
        } 
        else
        { 
            a[++top] = x; 
            return true; 
        } 
    } 
  
    //function to pop element from stack 
    char pop() 
    { 
        if (top < 0) 
        { 
        System.out.println("Stack Underflow"); 
        return 0; 
        } 
        else
        { 
            char x = a[top--]; 
            return x; 
        } 
    } 
} 
  
  
// Driver code 
class Main 
{ 
    //function to reverse the string 
    public static void reverse(StringBuffer str) 
    { 
        // Create a stack of capacity  
        // equal to length of string 
        int n = str.length(); 
        Stack obj = new Stack(n); 
          
        // Push all characters of string  
        // to stack 
        int i; 
        for (i = 0; i < n; i++) 
        obj.push(str.charAt(i)); 
      
        // Pop all characters of string  
        // and put them back to str 
        for (i = 0; i < n; i++) 
        {  
            char ch = obj.pop(); 
            str.setCharAt(i,ch); 
        } 
    }  
      
    //driver function 
    public static void main(String args[]) 
    { 
        //create a new string 
        StringBuffer s= new StringBuffer("GeeksQuiz"); 
          
        //call reverse method 
        reverse(s); 
          
        //print the reversed string 
        System.out.println("Reversed string is " + s); 
    } 
} 

//Output:
//Reversed string is ziuQskeeG

//Solution 2(by swapping)
// Java program to reverse a string without using stack  
public class GFG { 
// A utility function to swap two characters  
  
    static void swap(char a[], int index1, int index2) { 
        char temp = a[index1]; 
        a[index1] = a[index2]; 
        a[index2] = temp; 
    } 
  
// A stack based function to reverse a string  
    static void reverse(char str[]) { 
        // get size of string  
        int n = str.length, i; 
  
        for (i = 0; i < n / 2; i++) { 
            swap(str, i, n - i - 1); 
        } 
    } 
  
// Driver program to test above functions  
    public static void main(String[] args) { 
        char str[] = "abc".toCharArray(); 
  
        reverse(str); 
        System.out.printf("Reversed string is " + String.valueOf(str)); 
    } 
} 
// This code is contributed by 29AjayKumar 

//Output:
//Reversed string is cba
