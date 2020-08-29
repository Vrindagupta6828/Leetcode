/* Problem:
Who doesn't like salary hikes? In script, the freshers work for free during their training period. But now since their training period is over and since it is script the rules over here are quite weird. All employees over here don't get salary hikes, rather it depends on the HR who randomly selects some employees and increases their salary.

There are N number of freshers and their initial salary is 0. The HR doesn't increase the salary of all his employees at once rather selects a group.

At a given time, he randomly selects a contiguous group of employees from N described by l and r and increases their salary by value V. Hence the employees in range of l and r, both inclusive, get salary hike and are happy. The other employees not in range between l to r get no hike.

The HR increases the salary only for Q number of times. So after Q opeartions, answer the total salary of all the employees.

Input:
The first line consists of a single integer T denoting the number of test cases. The first line of each test case consists of two integers N and Q. Then Q lines follows: - Three integer numbers l, r, V

Output:
For each test case print a single integer - the sum of salary of all employees after Q increments.

Constraints
1≤T≤1000
2≤N,Q,l,r,V≤109
Sample Input:
1
3 1 
0 2 1

Sample Output:
3
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
		Scanner sc=new Scanner(System.in);
        Long t=0L;
		if(sc.hasNext())
		t=sc.nextLong();
		sc.nextLine();
		for(int i=0;i<t;i++){
		    String s=sc.nextLine();
		    String[] s1=s.split(" ");
		    long n=Long.parseLong(s1[0]);
		    long q=Long.parseLong(s1[1]);
		    long sum=0;
		    for(int j=0;j<q;j++){
		      String s3=sc.nextLine();
		      String[] s4=s3.split(" ");
		      long l=Long.parseLong(s4[0]);
		      long r=Long.parseLong(s4[1]);
		      long v=Long.parseLong(s4[2]);
		      sum+=(v*(r-l+1));}
		    System.out.println(sum);
		}
	}
}
