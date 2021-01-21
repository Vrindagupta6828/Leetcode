/* Question:
Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included. Write a program to find Nth Ugly Number.

Example 1:

Input:
N = 10
Output: 12
Explanation: 10th ugly number is 12.
Example 2:

Input:
N = 4
Output: 4
Explanation: 4th ugly number is 4.
Your Task:
You don't need to read input or print anything. Your task is to complete the function getNthUglyNo() which takes an integer n as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 104  */

//Brute force(checks for each no. ugly or not by cal. highest power of 2,3 or 5)(o(1) space)
// Java program to find nth ugly number
class GFG {
 
    /*This function divides a by greatest
    divisible power of b*/
    static int maxDivide(int a, int b)
    {
        while (a % b == 0)
            a = a / b;
        return a;
    }
 
    /* Function to check if a number
    is ugly or not */
    static int isUgly(int no)
    {
        no = maxDivide(no, 2);
        no = maxDivide(no, 3);
        no = maxDivide(no, 5);
 
        return (no == 1) ? 1 : 0;
    }
 
    /* Function to get the nth ugly
    number*/
    static int getNthUglyNo(int n)
    {
        int i = 1;
 
        // ugly number count
        int count = 1;
 
        // check for all integers
        // until count becomes n
        while (n > count) {
            i++;
            if (isUgly(i) == 1)
                count++;
        }
        return i;
    }
 
    /* Driver Code*/
    public static void main(String args[])
    {
        int no = getNthUglyNo(150);
       
        // Function call
        System.out.println("150th ugly "
                           + "no. is " + no);
    }
}
 
 
//Solution 2 (o(n(log(n)time and o(n) space)(as each ugly no. is 1 ugly no. multiplied by 2,3 or 5)
class Solution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n) {
        // code here
        if(n<4) return n;
        TreeSet<Long> s=new TreeSet<>();
        s.add(1L);
        long temp=-1;
        while(n-->0){
            temp=s.pollFirst();
            s.add(temp*2);
            s.add(temp*3);
            s.add(temp*5);
        }
        return temp;
    }
}

//Solution 3(O(N) time and space)
// Java program to find nth ugly number
import java.lang.Math;
 
class UglyNumber
{
    // Function to get the nth ugly number
    int getNthUglyNo(int n)
    {
         // To store ugly numbers
        int ugly[] = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;
        int next_multiple_of_2 = 2;
        int next_multiple_of_3 = 3;
        int next_multiple_of_5 = 5;
        int next_ugly_no = 1;
 
        ugly[0] = 1;
 
        for (int i = 1; i < n; i++) 
        {
            next_ugly_no
                = Math.min(next_multiple_of_2,
                           Math.min(next_multiple_of_3,
                                    next_multiple_of_5));
 
            ugly[i] = next_ugly_no;
            if (next_ugly_no == next_multiple_of_2) 
            {
                i2 = i2 + 1;
                next_multiple_of_2 = ugly[i2] * 2;
            }
            if (next_ugly_no == next_multiple_of_3) 
            {
                i3 = i3 + 1;
                next_multiple_of_3 = ugly[i3] * 3;
            }
            if (next_ugly_no == next_multiple_of_5) 
            {
                i5 = i5 + 1;
                next_multiple_of_5 = ugly[i5] * 5;
            }
        } 
         
        // End of for loop (i=1; i<n; i++)
        return next_ugly_no;
    }
 
    // Driver code
    public static void main(String args[])
    {
         
        int n = 150;
         
        // Function call
        UglyNumber obj = new UglyNumber();
        System.out.println(obj.getNthUglyNo(n));
    }
}
