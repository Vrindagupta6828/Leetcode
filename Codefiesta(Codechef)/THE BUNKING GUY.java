/* Problem:
There are N students in a class, roll numbered from 1 to N. When a student doesn't like a subject, he bunks the lecture. But for a given lecture only one student bunks and rest all attends. The teacher wants to find out the roll number of the student bunking the lecture. So for a given N and an array A of length N-1, help the teacher in finding the missing student.

Input:
The first line contains a single integer T denoting the number of test cases. The first line of each test case conatins an integer N. The second line of each test case contains N-2 space seperated integers, A[1],A[2],…,A[n-1] denoting the values of A.

Output:
For each test case print a single integer - the missing roll number of student on new line.

Constraints
1≤T≤1000
2≤N≤109
1≤A[i]≤109
Sample Input:
1
4
3 1 2

Sample Output:
4 */

//Solution:

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	     String te=br.readLine();int t=0;
	     if(te!=null)
	       t=Integer.parseInt(te);
	     for(int j=0;j<t;j++){
	         int sum2=0;
            int num = Integer.parseInt(br.readLine()); //Length of Array
            String s= br.readLine(); //Input the number seperated by space
           String[] s1 = s.split(" ");
           int[] arr= new int[s1.length];
for(int i=0;i<s1.length;i++)
{
    arr[i]=Integer.parseInt(s1[i]);
    sum2+=arr[i];
}
int sum1=num*(num+1)/2;
      System.out.println(sum1-sum2);
		// your cyode goes here
	}
}
}
