/* Question:
You are given an array of characters which is basically a sentence. However there is no space between different words and the first letter of every word is in uppercase. You need to print this sentence after following amendments:
(i) Put a single space between these words.
(ii) Convert the uppercase letters to lowercase.

Examples:

Input : BruceWayneIsBatman
Output : bruce wayne is batman

Input :  You
Output :  you   */

//Solution 1
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
			if(!Character.isUpperCase(s.charAt(i)))
				sb.append(s.charAt(i));
			else 
				{sb.append(" ");
			    sb.append(Character.toLowerCase(s.charAt(i)));}
		}
		System.out.println(sb.toString());
}}}

//Solution(o(n) time and o(1) space)
// Java program to put spaces between words starting 
// with capital letters. 
  
import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
class AddSpaceinSentence 
{ 
    // Function to amend the sentence 
    public static void amendSentence(String sstr) 
    { 
        char[] str=sstr.toCharArray(); 
          
        // Traverse the string 
        for (int i=0; i < str.length; i++) 
        { 
            // Convert to lowercase if its 
            // an uppercase character 
            if (str[i]>='A' && str[i]<='Z') 
            { 
                str[i] = (char)(str[i]+32); 
                  
                // Print space before it 
                // if its an uppercase character 
                if (i != 0) 
                    System.out.print(" "); 
      
                // Print the character 
                System.out.print(str[i]); 
            } 
      
            // if lowercase character 
            // then just print 
            else
            System.out.print(str[i]); 
        } 
    }      
      
    // Driver Code 
    public static void main (String[] args)  
    { 
        String str ="BruceWayneIsBatman"; 
        amendSentence(str); 
    } 
} 
