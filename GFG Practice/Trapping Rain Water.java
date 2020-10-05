/* Question:
Given an array arr[] of N non-negative integers representing height of blocks at index i as Ai where the width of each block is 1. Compute how much water can be trapped in between blocks after raining.
Structure is like below:
|  |
|_|
We can trap 2 units of water in the middle gap.



Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. Each test case contains an integer N denoting the size of the array, followed by N space separated numbers to be stored in array.

Output:
Output the total unit of water trapped in between the blocks.

Constraints:
1 <= T <= 100
3 <= N <= 107
0 <= Ai <= 108

Example:
Input:
2
4
7 4 0 9
3
6 9 9

Output:
10
0

Explanation:
Testcase 1: Water trapped by block of height 4 is 3 units, block of height 0 is 7 units. So, total unit of water trapped is 10 units.  */

//Solution
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    //static Scanner sc=new Scanner(System.in);
	public static void main (String[] args) throws IOException{
		//code
		/*int t=sc.nextInt();
		while(t>0){
		    int n=sc.nextInt();
		    int[] arr=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }*/
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    int startpos=0,endpos=n-1,water=0;int j=1,p=1;
		    while(startpos<endpos && startpos+j<endpos && endpos-p>startpos){
		    if(arr[startpos]<=arr[endpos]){
		        int i=startpos+j;
		        if(arr[i]<arr[startpos] && arr[i]<arr[endpos])
		          water+=arr[startpos]-arr[i];
		        else
		          {startpos=i;j=0;}
		          j++;}
		    else {
		        int i=endpos-p;
		            if(arr[i]<arr[startpos] && arr[i]<arr[endpos])
		               water+=arr[endpos]-arr[i];
		            else
		               {endpos=i;p=0;}
		        p++;
		    }
		    } 
		    System.out.println(water);
		}
		    }
}
