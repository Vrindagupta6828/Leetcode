/* Question:
Given two strings str1 and str2, find if str1 is a subsequence of str2. A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements (source: wiki). Expected time complexity is linear.

Examples :

Input: str1 = "AXY", str2 = "ADXCPY"
Output: True (str1 is a subsequence of str2)

Input: str1 = "AXY", str2 = "YADXCP"
Output: False (str1 is not a subsequence of str2)

Input: str1 = "gksrek", str2 = "geeksforgeeks"
Output: True (str1 is a subsequence of str2)   */

//Solution 1
// Recursive Java program to check if a string 
// is subsequence of another string 
import java.io.*; 
  
class SubSequence 
{ 
    // Returns true if str1[] is a subsequence of str2[] 
    // m is length of str1 and n is length of str2 
    static boolean isSubSequence(String str1, String str2, int m, int n) 
    { 
        // Base Cases 
        if (m == 0)  
            return true; 
        if (n == 0)  
            return false; 
              
        // If last characters of two strings are matching 
        if (str1.charAt(m-1) == str2.charAt(n-1)) 
            return isSubSequence(str1, str2, m-1, n-1); 
  
        // If last characters are not matching 
        return isSubSequence(str1, str2, m, n-1); 
    } 
      
    // Driver program 
    public static void main (String[] args)  
    { 
        String str1 = "gksrek"; 
        String str2 = "geeksforgeeks"; 
        int m = str1.length(); 
        int n = str2.length(); 
        boolean res = isSubSequence(str1, str2, m, n); 
        if(res) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
    } 
} 

//Solution 2
// Iterative Java program to check if a string  
// is subsequence of another string 
import java.io.*; 
  
class GFG { 
      
    // Returns true if str1[] is a subsequence  
    // of str2[] m is length of str1 and n is 
    // length of str2 
    static boolean isSubSequence(String str1,  
                    String str2, int m, int n) 
    { 
        int j = 0; 
          
        // Traverse str2 and str1, and compare  
        // current character of str2 with first 
        // unmatched char of str1, if matched  
        // then move ahead in str1 
        for (int i = 0; i < n && j < m; i++) 
            if (str1.charAt(j) == str2.charAt(i)) 
                j++; 
  
        // If all characters of str1 were found 
        // in str2 
        return (j == m);  
    } 
      
    // Driver program to test methods of 
    // graph class 
    public static void main (String[] args)  
    { 
        String str1 = "gksrek"; 
        String str2 = "geeksforgeeks"; 
        int m = str1.length(); 
        int n = str2.length(); 
        boolean res = isSubSequence(str1, str2, m, n); 
          
        if(res) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
    } 
} 
  
