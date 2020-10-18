/* Question:
Given a binary string, that is it contains only 0s and 1s. We need to make this string a sequence of alternate characters by flipping some of the bits, our goal is to minimize the number of bits to be flipped.
Examples :

Input : str = “001”
Output : 1
Minimum number of flips required = 1
We can flip 1st bit from 0 to 1 

Input : str = “0001010111”
Output : 2
Minimum number of flips required = 2
We can flip 2nd bit from 0 to 1 and 9th 
bit from 1 to 0 to make alternate 
string “0101010101”.
Expected time complexity : O(n) where n is length of input string.   */

//Solution
// Java program to find minimum number of 
// flip to make binary string alternate 
class GFG  
{ 
    //  Utility method to flip a character 
    public static char flip(char ch) 
    { 
        return (ch == '0') ? '1' : '0'; 
    } 
       
    //  Utility method to get minimum flips when 
    //  alternate string starts with expected char 
    public static int getFlipWithStartingCharcter(String str, 
                                    char expected) 
    { 
        int flipCount = 0; 
        for (int i = 0; i < str.length(); i++) 
        { 
            //  if current character is not expected, 
            // increase flip count 
            if (str.charAt(i) != expected) 
                flipCount++; 
       
            //  flip expected character each time 
            expected = flip(expected); 
        } 
        return flipCount; 
    } 
       
    // method return minimum flip to make binary 
    // string alternate 
    public static int minFlipToMakeStringAlternate(String str) 
    { 
        //  return minimum of following two 
        //  1) flips when alternate string starts with 0 
        //  2) flips when alternate string starts with 1 
        return Math.min(getFlipWithStartingCharcter(str, '0'), 
                   getFlipWithStartingCharcter(str, '1')); 
    } 
       
    //  Driver code to test above method 
    public static void main(String args[]) 
    { 
        String str = "0001010111"; 
        System.out.println(minFlipToMakeStringAlternate(str)); 
    } 
} 
  
