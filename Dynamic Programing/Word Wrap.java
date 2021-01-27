/* Question:
Given a sequence of words, and a limit on the number of characters that can be put in one line (line width). Put line breaks in the given sequence such that the lines are printed neatly. Assume that the length of each word is smaller than the line width.

The word processors like MS Word do task of placing line breaks. The idea is to have balanced lines. In other words, not have few lines with lots of extra spaces and some lines with small amount of extra spaces.

The extra spaces includes spaces put at the end of every line except the last one.  
The problem is to minimize the following total cost.
 Cost of a line = (Number of extra spaces in the line)^3
 Total Cost = Sum of costs for all lines

For example, consider the following string and line width M = 15
 "Geeks for Geeks presents word wrap problem" 
     
Following is the optimized arrangement of words in 3 lines
Geeks for Geeks
presents word
wrap problem 

The total extra spaces in line 1, line 2 and line 3 are 0, 2 and 3 respectively. 
So optimal value of total cost is 0 + 2*2 + 3*3 = 13 

For example, consider the following two arrangement of same set of words:

1) There are 3 lines. One line has 3 extra spaces and all other lines have 0 extra spaces. Total extra spaces = 3 + 0 + 0 = 3. Total cost = 3*3*3 + 0*0*0 + 0*0*0 = 27.

2) There are 3 lines. Each of the 3 lines has one extra space. Total extra spaces = 1 + 1 + 1 = 3. Total cost = 1*1*1 + 1*1*1 + 1*1*1 = 3.  */

//Solution(o(n*n) time and space))

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static Scanner sc=new Scanner(System.in);
	public static void main (String[] args) {
		//code
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    int[] arr=new int[n+1];
		    for(int i=1;i<=n;i++)
		       arr[i]=sc.nextInt();
		    int m=sc.nextInt();
		    
		    int[][] space=new int[n+1][n+1];
		    int[][] ls=new int[n+1][n+1];
		    int[] cs=new int[n+1];
		    int[] p=new int[n+1];
		    
		    for(int i=1;i<=n;i++){
		        space[i][i]=m-arr[i];
		        for(int j=i+1;j<=n;j++){
		            space[i][j]=space[i][j-1]-arr[j]-1;
		        }
		    }
		    
		    for(int i=1;i<=n;i++){
		        for(int j=i;j<=n;j++){
		            if(space[i][j]<0)
		               ls[i][j]=Integer.MAX_VALUE;
		            else if(j==n)
		               ls[i][j]=0;
		            else
		               ls[i][j]=space[i][j]*space[i][j];
		        }
		    }
		    
		    for(int i=1;i<=n;i++){
		        cs[i]=Integer.MAX_VALUE;
		        for(int j=1;j<=i;j++){
		            if(cs[i-1]!=Integer.MAX_VALUE && ls[j][i]!=Integer.MAX_VALUE &&
		               cs[j-1]+ls[j][i]<cs[i])
		                {  cs[i]=cs[j-1]+ls[j][i];
		                   p[i]=j;
		                }
		    }
		    }
		    
		    printp(p,n);
		    
		    System.out.println();
		}
	}
	
	static void printp(int[] p,int n){
	    if(p[n]==1)
	        System.out.print(p[n]+" "+n+" ");
	    else{
	        printp(p,p[n]-1);
	        System.out.print(p[n]+" "+n+" ");
	    }
	}
}
