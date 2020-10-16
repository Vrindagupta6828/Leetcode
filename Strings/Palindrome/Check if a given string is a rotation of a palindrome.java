/* Question:
Given a string, check if it is a rotation of a palindrome. For example your function should return true for “aab” as it is a rotation of “aba”.
Examples:

Input:  str = "aaaad"
Output: 1  
// "aaaad" is a rotation of a palindrome "aadaa"

Input:  str = "abcd"
Output: 0
// "abcd" is not a rotation of any palindrome.  */

//Solution1 (o(n^2))
// Java program to check if a given string 
// is a rotation of a palindrome 
import java.io.*; 
  
class Palindrome { 
    // A utility function to check if a string str is palindrome 
    static boolean isPalindrome(String str) 
    { 
        // Start from leftmost and rightmost corners of str 
        int l = 0; 
        int h = str.length() - 1; 
  
        // Keep comparing characters while they are same 
        while (h > l) 
            if (str.charAt(l++) != str.charAt(h--)) 
                return false; 
  
        // If we reach here, then all characters were matching 
        return true; 
    } 
  
    // Function to check if a given string is a rotation of a 
    // palindrome 
    static boolean isRotationOfPalindrome(String str) 
    { 
        // If string iteself is palindrome 
        if (isPalindrome(str)) 
            return true; 
  
        // Now try all rotations one by one 
        int n = str.length(); 
        for (int i = 0; i < n - 1; i++) { 
            String str1 = str.substring(i + 1); 
            String str2 = str.substring(0, i + 1); 
  
            // Check if this rotation is palindrome 
            if (isPalindrome(str1 + str2)) 
                return true; 
        } 
        return false; 
    } 
  
    // driver program 
    public static void main(String[] args) 
    { 
        System.out.println((isRotationOfPalindrome("aab")) ? 1 : 0); 
        System.out.println((isRotationOfPalindrome("abcde")) ? 1 : 0); 
        System.out.println((isRotationOfPalindrome("aaaad")) ? 1 : 0); 
    } 
} 

//Solution 2(o(n))
// Java implementation of the approach  
import java.util.*; 
  
class GFG  
{ 
  
// Function to check if we have found  
// a palindrome of same length as the input  
// which is a rotation of the input string  
static boolean checkPal(int x, int len)  
{ 
    if (x == len) 
    { 
        return true; 
    }  
    else if (x > len)  
    { 
        if ((x % 2 == 0 && len % 2 == 0) || 
            (x % 2 != 0 && len % 2 != 0))  
        { 
            return true; 
        } 
    } 
    return false; 
} 
  
// Function to preprocess the string  
// for Manacher's Algorithm  
static String reform(String s) 
{ 
    String s1 = "$#"; 
  
    // Adding # between the characters  
    for (int i = 0; i < s.length(); i++)  
    { 
        s1 += s.charAt(i); 
        s1 += '#'; 
    } 
  
    s1 += '@'; 
    return s1; 
} 
  
// Function to find the longest palindromic  
// substring using Manacher's Algorithm  
static boolean longestPal(String s, int len)  
{ 
  
    // Current Left Position  
    int mirror = 0; 
  
    // Center Right Position  
    int R = 0; 
  
    // Center Position  
    int C = 0; 
  
    // LPS Length Array  
    int[] P = new int[s.length()]; 
    int x = 0; 
  
    // Get currentLeftPosition Mirror  
    // for currentRightPosition i  
    for (int i = 1; i < s.length() - 1; i++) 
    { 
        mirror = 2 * C - i; 
  
        // If currentRightPosition i is  
        // within centerRightPosition R  
        if (i < R)  
        { 
            P[i] = Math.min((R - i), P[mirror]); 
        } 
  
        // Attempt to expand palindrome centered  
        // at currentRightPosition i  
        while (s.charAt(i + (1 + P[i])) ==  
               s.charAt(i - (1 + P[i]))) 
        { 
            P[i]++; 
        } 
  
        // Check for palindrome  
        boolean ans = checkPal(P[i], len); 
        if (ans)  
        { 
            return true; 
        } 
  
        // If palindrome centered at currentRightPosition i  
        // expand beyond centerRightPosition R,  
        // adjust centerPosition C based on expanded palindrome  
        if (i + P[i] > R)  
        { 
            C = i; 
            R = i + P[i]; 
        } 
    } 
    return false; 
} 
  
// Driver code  
public static void main(String[] args)  
{ 
    String s = "aaaad"; 
    int len = s.length(); 
    s += s; 
    s = reform(s); 
    System.out.println(longestPal(s, len) ? 1 : 0); 
} 
}  
