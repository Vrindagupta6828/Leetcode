/* Problem:

The Fibonacci sequence is defined as F(n) = F(n-1) + F(n-2). You have developed two sequences of numbers. The first sequence that uses the bitwise XOR operation instead of the addition method is called the Xoronacci number. It is described as follows:

X(n) = X(n-1) XOR X(n-2)

The second sequence that uses the bitwise XNOR operation instead of the addition method is called the XNoronacci number. It is described as follows:

E(n) = E(n-1) XNOR E(n-2)

The first and second numbers of the sequence are as follows:

X(1) = E(1) = a
X(2) = E(2) = b

Your task is to determine the value of max(X(n),E(n)), where n is the n th term of the Xoronacci and XNoronacci sequence.

Input:
The first line consists of a single integer T denoting the number of test cases. The first and the only line of each test case consists of three space separated integers a, b and n.

Output:
For each test case print a single integer max(X(n),E(n)).

Constraints

1≤T≤1000
2≤a,b,n≤1000000000000

Sample Input:
1
3 4 2 

Sample Output:
4

EXPLANATION:
Xoronacci Sequence : 3 4 7 …….

XNoronacci Sequence : 3 4 0 …….

Here n = 2. Hence max(X(2),E(2)) = 4
/*

//Solution

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{   static Scanner sc= new Scanner (System.in);
    static long togglebit(long n) 
    { 
        if (n == 0) 
            return 1; 
  
        // Make a copy of n as we are 
        // going to change it. 
        long i = n; 
  
        // Below steps set bits after 
        // MSB (including MSB) 
  
        // Suppose n is 273 (binary 
        // is 100010001). It does following 
        // 100010001 | 010001000 = 110011001 
        n |= n >> 1; 
  
        // This makes sure 4 bits 
        // (From MSB and including MSB) 
        // are set. It does following 
        // 110011001 | 001100110 = 111111111 
        n |= n >> 2; 
        n |= n >> 4; 
        n |= n >> 8; 
        n |= n >> 16; 
  
        return (i ^ n); 
    } 
  
    // Returns XNOR of num1 and num2 
    static long xnor(long num1, long num2) 
    { 
        // if num2 is greater then 
        // we swap this number in num1   
        if (num1 < num2) 
        { 
            long temp = num1; 
            num1 = num2; 
            num2 = temp; 
        } 
      
        num1 = togglebit(num1); 
      
        return (num1 ^ num2); 
    } 

/* Name of the class has to be "Main" only if the class is public. */
    
	public static void main (String[] args) throws java.lang.Exception {
		int t=sc.nextInt();
		while(t-->0){
	    long a = sc.nextLong();
		long b = sc.nextLong();
		long n = sc.nextLong();
		n--;
		long[] xor = {a,b,a^b};
		long[] xnor = {a,b,xnor(a,b)};
		System.out.println(Math.max(xor[(int)(n%3)],xnor[(int)(n%3)]));
	}
		}	
	}

   
