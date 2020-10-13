/* Question:
We are given an array of strings, we need to sort the array in increasing order of string lengths.

Examples:

Input : {"GeeksforGeeeks", "I", "from", "am"}
Output : I am from GeeksforGeeks

Input :  {"You", "are", "beautiful", "looking"}
Output : You are looking beautiful  */

//Solution 1
import java.util.*;
public class sample {
	
	static class StringCompare implements Comparator<String>{
		public int compare(String arg0,String arg1) {
			if (arg0.length()>=arg1.length())   return 1;
			else return -1;
		}
	}
	
	static void arrange(String[] temp,int n) {
		
		StringCompare c=new StringCompare();
		PriorityQueue<String> pq=new PriorityQueue<>(c);
		for(int i=0;i<n;i++)
			pq.add(temp[i]);
	    while(!pq.isEmpty()) {
	    	System.out.print(pq.peek()+" ");
	    	pq.poll();
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] s= {"You", "are", "beautiful", "looking"};
        int n=s.length;
        arrange(s,n);
        
	}

}

//Solution 2(insertion sort)
/ Java program to sort an Array of  
// Strings according to their lengths 
import java.util.*; 
  
class solution 
{ 
  
// Function to print the sorted array of string 
// void printArraystring(string,int); 
  
// Function to Sort the array of string 
// according to lengths. This function  
// implements Insertion Sort.  
static void sort(String []s, int n) 
{ 
    for (int i=1 ;i<n; i++) 
    { 
        String temp = s[i]; 
  
        // Insert s[j] at its correct position 
        int j = i - 1; 
        while (j >= 0 && temp.length() < s[j].length()) 
        { 
            s[j+1] = s[j]; 
            j--; 
        } 
        s[j+1] = temp; 
    } 
} 
  
// Function to print the sorted array of string 
static void printArraystring(String str[], int n) 
{ 
    for (int i=0; i<n; i++) 
        System.out.print(str[i]+" "); 
} 
  
// Driver function 
public static void main(String args[]) 
{ 
    String []arr = {"GeeksforGeeks", "I", "from", "am"}; 
    int n = arr.length; 
      
    // Function to perform sorting 
    sort(arr,n); 
    // Calling the function to print result 
    printArraystring(arr, n); 
      
} 
} 
