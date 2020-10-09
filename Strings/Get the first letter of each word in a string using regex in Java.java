/*Question:
Given a string, extract the first letter of each word in it. “Words” are defined as contiguous strings of alphabetic characters i.e. any upper or lower case characters a-z or A-Z.

Examples:

Input : Geeks for geeks
Output :Gfg
        
Input : United Kingdom
Output : UK   */

//Solution
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
  
public class Test 
{ 
    static void printFirst(String s) 
    { 
        Pattern p = Pattern.compile("\\b[a-zA-Z]"); 
        Matcher m = p.matcher(s); 
  
        while (m.find()) 
            System.out.print(m.group()); 
  
        System.out.println(); 
    } 
  
    public static void main(String[] args) 
    { 
        String s1 = "Geeks for Geeks"; 
        String s2 = "A Computer Science Portal for Geeks"; 
        printFirst(s1); 
        printFirst(s2); 
    } 
} 

//output:   GfG
//ACSPfG
