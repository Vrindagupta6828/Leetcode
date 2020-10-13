/* Question:
Given a string of lowercase characters from ‘a’ – ‘z’. We need to write a program to print the characters of this string in sorted order.

Examples:

Input : bbccdefbbaa 
Output : aabbbbccdef

Input : geeksforgeeks
Output : eeeefggkkorss   */

//Solution 1(o(nlogn))
// Java program to sort a string of characters  
  
import java.util.Arrays; 
  
class GFG { 
  
// function to print string in sorted order  
    static void sortString(String str) { 
        char []arr = str.toCharArray(); 
        Arrays.sort(arr); 
        System.out.print(String.valueOf(arr)); 
    } 
  
// Driver program to test above function  
    public static void main(String[] args) { 
        String s = "geeksforgeeks"; 
        sortString(s); 
    } 
} 

//Solution 2(o(n))
// Java program to sort 
// a string of characters 
public class SortString{ 
    static final int MAX_CHAR = 26; 
  
    // function to print string in sorted order 
    static void sortString(String str) { 
  
        // Hash array to keep count of characters. 
        int letters[] = new int[MAX_CHAR]; 
  
        // Traverse string and increment 
        // count of characters 
        for (char x : str.toCharArray()) { 
  
            // 'a'-'a' will be 0, 'b'-'a' will be 1, 
            // so for location of character in count 
            // array we will do str[i]-'a'. 
            letters[x - 'a']++; 
        } 
  
        // Traverse the hash array and print 
        // characters 
        for (int i = 0; i < MAX_CHAR; i++) { 
            for (int j = 0; j < letters[i]; j++) { //to print the freq f that particualr character
                System.out.print((char) (i + 'a')); 
            } 
        } 
    } 
  
    // Driver program to test above function 
    public static void main(String[] args) { 
        sortString("geeksforgeeks"); 
    } 
} 
