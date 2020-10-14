/* Question:
Given a string find its first uppercase letter

Examples :

Input : geeksforgeeKs
Output : K

Input  : geekS
Output : S   */


//Solution 1(linear search)
// Java program to find the first 
// uppercase letter using linear search 
import java.io.*; 
import java.util.*; 
  
class GFG { 
  
    // Function to find string which has 
    // first character of each word. 
    static char first(String str) 
    { 
        for (int i = 0; i < str.length(); i++) 
            if (Character.isUpperCase(str.charAt(i))) 
                return str.charAt(i); 
        return 0; 
    } 
      
    // Driver program  
    public static void main(String args[]) 
    { 
        String str = "geeksforGeeKS"; 
        char res = first(str); 
        if (res == 0) 
            System.out.println("No uppercase letter"); 
        else
            System.out.println(res); 
    } 
} 

//Solution 2
// Java program to find the 
// first uppercase letter. 
import java.io.*; 
  
class GFG { 
      
    // Function to find string which has 
    // first character of each word. 
    static char first(String str, int i) 
    { 
        if (str.charAt(i) == '\0') 
            return 0; 
        if (Character.isUpperCase(str.charAt(i)))  
                return str.charAt(i); 
        return first(str, i + 1); 
    } 
      
    // Driver code 
    public static void main(String args[]) 
    { 
        String str = "geeksforGeeKS"; 
        char res = first(str,0); 
        if (res == 0) 
            System.out.println("No uppercase letter"); 
        else
            System.out.println (res ); 
    } 
} 
