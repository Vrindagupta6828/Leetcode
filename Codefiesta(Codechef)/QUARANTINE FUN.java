/*Problem

Chef and Abhishek both are fighting for the post of Chairperson to be part of ACE committee and are trying their best. To select only one student their teacher gave them a binary string (string consisting of only 0's and 1's) and asked them to find number of sub-strings present in the given string that satisfy the following condition:

The substring should start with 0 and end with 1 or the substring should start with 1 and end with 0 but not start with 0 and end with 0 and start with 1 and end with 1. More formally, strings such as 100,0101 are allowed since they start and end with different characters. But strings such as 0110,1101 are not allowed because they start and end with same characters.

Both Chef and Abhishek try their best to solve it but couldn't do it. You being a very good friend of Chef, he asks for your help so that he can solve it and become the Chairperson.

Input:
The first line of the input contains a single integer T denoting the number of testcases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the length of the string. The second line of each test case contains a binary string of length N.

Output:
For each test case, print a single line containing one integer ― the number of sub strings satisfying above conditions.

Constraints
1≤T≤1000
2≤N≤109
Binary string consist's only 0 and 1.

Sample Input:
1
4

1010

Sample Output:
4
EXPLANATION:
All possible substring are : { (1),(0),(1),(0),(10),(01),(10),(101),(010),(1010) }. Out of these only 4 substrings {(10),(01),(10),(1010)} start and end with different characters. Hence the answer 4.
*/

//Solution

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		try {
		    
		     Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            long n=sc.nextLong();
            String s=sc.next();
            long sum=0;
            long sum1=0;
            for (long i=0;i<s.length();i++){
                if (s.charAt((int) i)=='1'){
                    sum1++;
                }
                else {
                    sum++;
                }}
            System.out.println(sum*sum1);
        }
		    
		} catch(Exception e) {
		} 
		
	}
}
