/*Question:
Find the smallest number such that the sum of its digits is N and it is divisible by 10^N.

Examples :

Input : N = 5
Output : 500000
500000 is the smallest number divisible
by 10^5 and sum of digits as 5.

Input : N = 20
Output : 29900000000000000000000   */

//Solution 1
import java.util.*;

public class stringsrithmetic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		LinkedList<Integer> number=new LinkedList<>();
        for(int i=0;i<n;i++)  number.addLast(0);
        if(n<=9)  number.addFirst(n);
        else {
        	number.addFirst(9);
        	n-=9;
        	while(n>9) {
        		number.addFirst(9);
                n-=9;
        	}
        	number.addFirst(n);
        }
        for(int i=0;i<number.size();i++)
           System.out.print(number.get(i));
	}

}

//Solution 2
// Java program to find smallest  
// number to find smallest number  
// with N as sum of digits and  
// divisible by 10^N. 
import java.io.*; 
  
class GFG  
{ 
  
static void digitsNum(int N) 
{ 
    // If N = 0 the string will be 0 
    if (N == 0)  
    System.out.println("0"); 
          
      
    // If n is not perfectly divisible 
    // by 9 output the remainder 
    if (N % 9 != 0)  
        System.out.print((N % 9)); 
      
      
    // Print 9 N/9 times  
    for (int i = 1; i <= (N / 9); ++i)  
        System.out.print("9"); 
          
      
    // Append N zero's to the number so 
    // as to make it divisible by 10^N  
    for (int i = 1; i <= N; ++i)  
        System.out.print("0"); 
        System.out.print("" ); 
      
} 
  
    // Driver Code 
    public static void main (String[] args)  
    { 
    int N = 5; 
    System.out.print("The number is : "); 
    digitsNum(N); 
    } 
}  
