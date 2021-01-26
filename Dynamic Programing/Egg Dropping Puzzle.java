/* Question:
Suppose you have N eggs and you want to determine from which floor in a K-floor building you can drop an egg such that it doesn't break. You have to determine the minimum number of attempts you need in order find the critical floor in the worst case while using the best strategy.There are few rules given below. 

An egg that survives a fall can be used again.
A broken egg must be discarded.
The effect of a fall is the same for all eggs.
If the egg doesn't break at a certain floor, it will not break at any floor below.
If the eggs breaks at a certain floor, it will break at any floor above.
For more description on this problem see wiki page

Example 1:

Input:
N = 2, K = 10
Output: 4
Example 2:

Input:
N = 3, K = 5
Output: 3
Your Task:
Complete the function eggDrop() which takes two positive integer N and K as input parameters and returns the minimum number of attempts you need in order to find the critical floor.

Expected Time Complexity : O(N*K)
Expected Auxiliary Space: O(N*K)

Constraints:
1<=N<=10
1<=K<=50  */

//Solution 1(memorization)
class EggDrop 
{   
    static int[][] t;
    
    static int eggDrop(int n, int k) 
	  {
	    // Your code here
	    t=new int[n+1][k+1];
	    for(int i=0;i<=n;i++){
	        for(int j=0;j<=k;j++){
	            t[i][j]=-1;
          }
      }
	    return solve(n,k);
    }
	
    static int solve(int n,int k){
	     if(n==1 ||k==0 || k==1)
	        return k;
	     if(t[n][k]!=-1) return t[n][k];
	     else{
	           int min=Integer.MAX_VALUE;
	           for(int i=1;i<=k;i++){
	              int temp_ans=1+Math.max(solve(n-1,i-1),solve(n,k-i));
	              min=Math.min(min,temp_ans);
	           }
	           t[n][k]=min;return min;
	         }
     }
	}

//Optimise:

class EggDrop 
{   
    static int[][] t;
    
    static int eggDrop(int n, int k) 
	  {
	    // Your code here
	    t=new int[n+1][k+1];
	    for(int i=0;i<=n;i++){
	        for(int j=0;j<=k;j++){
	            t[i][j]=-1;
           }
      }
	    return solve(n,k);
    }
	
    static int solve(int n,int k){
	     if(n==1 ||k==0 || k==1)
	         return k;
	     if(t[n][k]!=-1) return t[n][k];
	  
	     int min=Integer.MAX_VALUE;
	     for(int i=1;i<=k;i++){
	        int left=-1,right=-1;
	        if(t[n-1][i-1]!=-1)
	           left=t[n-1][i-1];
	        else
	        {   left=solve(n-1,i-1);
	            t[n-1][i-1]=left;
	        }
	                   
	        if(t[n][k-i]!=-1)
	            right=t[n][k-i];
	         else
	         {  right=solve(n,k-i);
	            t[n][k-i]=right;
	         }
	               
	         int temp_ans=1+Math.max(left,right);
	         min=Math.min(min,temp_ans);
	       }
	       t[n][k]=min;return min;
	   }
	}

//DP(O(n*k^2) time and O(n*k) space)

static int eggDrop(int n, int k) 
    { 
        /* A 2D table where entery eggFloor[i][j]  
 will represent minimum number of trials  
needed for i eggs and j floors. */
        int eggFloor[][] = new int[n + 1][k + 1]; 
        int res; 
        int i, j, x; 
  
        // We need one trial for one floor and 
        // 0 trials for 0 floors 
        for (i = 1; i <= n; i++) { 
            eggFloor[i][1] = 1; 
            eggFloor[i][0] = 0; 
        } 
  
        // We always need j trials for one egg 
        // and j floors. 
        for (j = 1; j <= k; j++) 
            eggFloor[1][j] = j; 
  
        // Fill rest of the entries in table using 
        // optimal substructure property 
        for (i = 2; i <= n; i++) { 
            for (j = 2; j <= k; j++) { 
                eggFloor[i][j] = Integer.MAX_VALUE; 
                for (x = 1; x <= j; x++) { 
                    res = 1 + Math.max( 
                                  eggFloor[i - 1][x - 1], 
                                  eggFloor[i][j - x]); 
                    if (res < eggFloor[i][j]) 
                        eggFloor[i][j] = res; 
                } 
            } 
        } 
  
        // eggFloor[n][k] holds the result 
        return eggFloor[n][k]; 
    } 
