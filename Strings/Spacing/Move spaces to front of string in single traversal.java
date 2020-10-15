/* Question:
Given a string that has set of words and spaces, write a program to move all spaces to front of string, by traversing the string only once.

Examples:

Input  : str = "geeks for geeks"
Output : ste = "  geeksforgeeks"

Input  : str = "move these spaces to beginning"
Output : str = "    movethesespacestobeginning"
There were four space characters in input,
all of them should be shifted in front.   */

//Solution 1 (o(n) time and space)
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
			else 
				sb.insert(0, ' ');
		}
		System.out.println(sb.toString());
}}}

//Solution 2(using swap)(o(n) time and o(1) space)
// Java program to bring all spaces in front of  
// string using swapping technique  
class GFG  
{ 
  
    // Function to find spaces and move to beginning  
    static void moveSpaceInFront(char str[])  
    {  
        // Traverse from end and swap spaces  
        int i = str.length-1;  
        for (int j = i; j >= 0; j--)  
            if (str[j] != ' ') 
            { 
                char c = str[i]; 
                str[i] = str[j]; 
                str[j] = c; 
                i--; 
            } 
    }     
  
    // Driver code  
    public static void main(String[] args) 
    { 
        char str[] = "Hey there, it's GeeksforGeeks".toCharArray();  
        moveSpaceInFront(str);  
        System.out.println(String.valueOf(str)); 
    } 
} 

//Solution 3(without swap)(o(n) time and o(1) space)
// Java program to bring all spaces in front of 
// string using swapping technique 
class GFG  
{ 
  
// Function to find spaces and move to beginning 
static void moveSpaceInFront(char str[]) 
{ 
    // Keep copying non-space characters 
    int i = str.length-1; 
      
    for (int j = i; j >= 0; j--) 
        if (str[j] != ' ') 
            str[i--] = str[j]; 
  
    // Move spaces to be beginning 
    while (i >= 0) 
        str[i--] = ' '; 
} 
  
// Driver code 
public static void main(String[] args)  
{ 
    char str[] = "Hey there, it's GeeksforGeeks".toCharArray(); 
    moveSpaceInFront(str); 
    System.out.println(String.valueOf(str)); 
} 
} 
