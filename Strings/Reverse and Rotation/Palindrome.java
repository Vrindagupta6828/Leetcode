/* Question:
You are given a string ‘str’, the task is to check that reverses of all possible substrings of ‘str’ are present in ‘str’ or not.

Examples:

Input : str = "ab"
Output: "NO"
// all substrings are "a","b","ab" but reverse
// of "ab" is not present in str

Input : str = "aba"
Output: "YES"

Input : str = "abab"
Output: "NO"
// All substrings are "a", "b", "a", "b", "ab", 
// "ba", "ab", "aba", "bab", "abab" but reverse of
// "abab" is not present in str   */

//Solution
// Java program to check 
// if a string is perfect 
// reversible or nor 
import java.io.*; 
  
class GFG 
{ 
  
// This function basically  
// checks if string is  
// palindrome or not 
static boolean isReversible(String str) 
{ 
    int i = 0, j = str.length() - 1; 
  
    // iterate from 
    // left and right 
    while (i < j) 
    { 
        if (str.charAt(i) != str.charAt(j)) 
            return false; 
        i++; 
        j--; 
    } 
    return true; 
} 
  
// Driver Code 
public static void main (String[] args)  
{ 
    String str = "aba"; 
    if (isReversible(str)) 
        System.out.print("YES"); 
    else
        System.out.print( "NO"); 
} 
} 
  
/*
Output:

YES  */
