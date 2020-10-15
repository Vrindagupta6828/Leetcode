/*  Question: 
Given a string, remove all spaces from the string and return it.

Input:  "g  eeks   for ge  eeks  "
Output: "geeksforgeeks"
Expected time complexity is O(n) and only one traversal of string.  */

//Solution1
import java.util.*;
import java.lang.*;
import java.io.*;

class bjjvjh {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t-->0){
		    String s = sc.nextLine();
		    StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!=' ')
				sb.append(s.charAt(i));
		}
		System.out.println(sb.toString());
}}}

//Solution2
// An efficient Java program to remove all spaces 
// from a string 
class GFG 
{ 
  
// Function to remove all spaces  
// from a given string 
static int removeSpaces(char []str) 
{ 
    // To keep track of non-space character count 
    int count = 0; 
  
    // Traverse the given string. 
    // If current character 
    // is not space, then place  
    // it at index 'count++' 
    for (int i = 0; i<str.length; i++) 
        if (str[i] != ' ') 
            str[count++] = str[i]; // here count is 
                                    // incremented 
          
    return count; 
} 
  
// Driver code 
public static void main(String[] args) 
{ 
    char str[] = "g eeks for ge eeks ".toCharArray(); 
    int i = removeSpaces(str); 
    System.out.println(String.valueOf(str).subSequence(0, i)); 
} 
}  

//Solution 3
// Java program to remove  
// all spaces from a string 
  
class GFG { 
      
    // Function to remove all  
    // spaces from a given string 
    static String removeSpace(String str) 
    { 
        str = str.replaceAll("\\s",""); 
        return str; 
    } 
  
    // Driver Code 
    public static void main(String args[]) 
    { 
        String str = "g eeks for ge eeks "; 
        System.out.println(removeSpace(str)); 
    } 
} 
