/* Question:
Given two positive numbers calculate the minimum and maximum possible sums of two numbers. We are allowed to replace digit 5 with digit 6 and vice versa in either or both the given numbers.

Examples :

Input  : x1 = 645 x2 = 666
Output : Minimum Sum: 1100 (545 + 555)
         Maximum Sum: 1312 (646 + 666)

Input: x1 = 5466 x2 = 4555
Output: Minimum sum: 10010
        Maximum Sum: 11132   
        
Hint:Since both numbers are positive, we always get maximum sum if replace 5 with 6 in both numbers. And we get minimum sum if we replace 6 with 5 in both numbers. Below is C++ implementation based on this fact.
*/

//Solution
// Java program to find maximum and minimum 
// possible sums of two numbers that we can 
// get if replacing digit from 5 to 6 and vice 
// versa are allowed. 
class GFG { 
      
    // Find new value of x after replacing digit 
    // "from" to "to" 
    static int replaceDig(int x, int from, int to) 
    { 
          
        int result = 0; 
        int multiply = 1; 
      
        while (x > 0) 
        { 
            int reminder = x % 10; 
      
            // Required digit found, replace it 
            if (reminder == from) 
                result = result + to * multiply; 
      
            else
                result = result + reminder * multiply; 
      
            multiply *= 10; 
            x = x / 10; 
        } 
        return result; 
    } 
      
    // Returns maximum and minimum possible sums of 
    // x1 and x2 if digit replacements are allowed. 
    static void calculateMinMaxSum(int x1, int x2) 
    { 
          
        // We always get minimum sum if we replace 
        // 6 with 5. 
        int minSum = replaceDig(x1, 6, 5) + 
                    replaceDig(x2, 6, 5); 
      
        // We always get maximum sum if we replace 
        // 5 with 6. 
        int maxSum = replaceDig(x1, 5, 6) + 
                    replaceDig(x2, 5, 6); 
        System.out.print("Minimum sum = " + minSum); 
        System.out.print("\nMaximum sum = " + maxSum); 
    } 
      
    // Driver code 
    public static void main (String[] args) 
    { 
        int x1 = 5466, x2 = 4555; 
        calculateMinMaxSum(x1, x2); 
    } 
} 
  
