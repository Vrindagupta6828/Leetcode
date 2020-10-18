/* Question:
Given a binary string, find if it is possible to make all its digits equal (either all 0’s or all 1’s) by flipping exactly one bit.

Input: 101
Output: Yes
Explanation: In 101, the 0 can be flipped
             to make it all 1

Input: 11
Output: No
Explanation: No matter whichever digit you 
  flip, you will not get the desired string.

Input: 1
Output: Yes
Explanation: We can flip 1, to make all 0's  */

//Solution 1(o(n))
// Java program to check if a single bit can 
// be flipped to make all ones 
public class GFG { 
  
    // This function returns true if we can 
    // bits same in given binary string str. 
    static boolean canMakeAllSame(String str) 
    { 
        int zeros = 0, ones = 0; 
  
        // Traverse through given string and 
        // count numbers of 0's and 1's 
        for (int i = 0; i < str.length(); i++) { 
            char ch = str.charAt(i); 
            if (ch == '0') 
                ++zeros; 
            else
                ++ones; 
        } 
  
        // Return true if any of the two counts 
        // is 1 
        return (zeros == 1 || ones == 1); 
    } 
  
    // Driver code 
    public static void main(String args[]) 
    { 
        System.out.println(canMakeAllSame("101") ? "Yes" : "No"); 
    } 
} 

//Solution 2(o(n))
/*Check if all bits can be made same by single  
flip. Idea is to add the integer value all the 
elements in the given string. 
If the sum is 1 it indicates that there is 
   only single '1' in the string. 
If the sum is 0 it indicates that there is only 
   single '0' in the string. 
It takes O(n) time.*/
public class GFG { 
  
    static boolean isOneFlip(String str) 
    { 
        int sum = 0; 
        int n = str.length(); 
  
        // Traverse through given string and 
        // count the total sum of numbers 
        for (int i = 0; i < n; i++) 
            sum += str.charAt(i) - '0'; 
  
        // Return true if any of the two counts 
        // is 1 
        return (sum == n - 1 || sum == 1); 
    } 
  
    // Main function 
    public static void main(String args[]) 
    { 
        System.out.println(isOneFlip("101111111111") ? "Yes" : "No"); 
    } 
} 
