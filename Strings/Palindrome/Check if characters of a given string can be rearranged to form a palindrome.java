/* Question:
Given a string, Check if characters of the given string can be rearranged to form a palindrome.
For example characters of “geeksogeeks” can be rearranged to form a palindrome “geeksoskeeg”, but characters of “geeksforgeeks” cannot be rearranged to form a palindrome. */

//Solution(o(n))
public static boolean check(String s) {
		int[] count=new int[26];
		boolean isOdd=false;
		for(int i=0;i<s.length();i++) {
			count[s.charAt(i)-'a']++;
		}
		for(int a:count) {
			if(a%2==1) {
				if(isOdd) return false;
				else isOdd=true;
			}
		}
		return true;
	}

//Solution (o(n))
import java.util.ArrayList; 
import java.util.List; 
  
class GFG{ 
  
    /* 
     * function to check whether characters of a string can form a palindrome 
     */
    static boolean canFormPalindrome(String str) { 
  
        // Create a list 
        List<Character> list = new ArrayList<Character>(); 
  
        // For each character in input strings, 
        // remove character if list contains 
        // else add character to list 
        for (int i = 0; i < str.length(); i++) { 
            if (list.contains(str.charAt(i))) 
                list.remove((Character) str.charAt(i)); 
            else
                list.add(str.charAt(i)); 
        } 
  
        // if character length is even list is expected to be empty 
        // or if character length is odd list size is expected to be 1 
        if (str.length() % 2 == 0 && list.isEmpty() // if string length is even 
                || (str.length() % 2 == 1 && list.size() == 1)) // if string length is odd 
            return true; 
        else
            return false; 
  
    } 
  
    // Driver program 
    public static void main(String args[]) { 
        if (canFormPalindrome("geeksforgeeks")) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
  
        if (canFormPalindrome("geeksogeeks")) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
    } 
} 
