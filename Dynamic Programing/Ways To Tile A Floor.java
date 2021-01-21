/* Question:
Given a floor of dimensions 2 x W and tiles of dimensions 2 x 1, the task is to find the number of ways the floor can be tiled. A tile can either be placed horizontally i.e as a 1 x 2 tile or vertically i.e as 2 x 1 tile. Print the answer modulo 109+7.

 

Example 1:

Input:
W = 3
Output:
3
Explanation:
We need 3 tiles to tile the board
of size  2 x 3. 
We can tile in following ways:
1) Place all 3 tiles vertically. 
2) Place first tile vertically.
and remaining 2 tiles horizontally.
3) Place first 2 tiles horizontally
and remaining tiles vertically.
Example 2:

Input:
W = 4
Output:
5
Explanation:
For a 2 x 4 board, there are 5 ways
1) All 4 vertical
2) All 4 horizontal
3) First 2 vertical, remaining
2 horizontal.
4) First 2 horizontal, remaining
2 vertical.
5) Corner 2 vertical, middle
2 horizontal.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function numberOfWays() which takes an Integer N as input and returns the answer.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 105  */

//Solution 1(Bottom up approach o(n) time and space)
class Solution {
    static long[][] dp;
    static Long numberOfWays(int N) {
        // code here
        dp=new long[3][N+1];
        way(2,N);
        return dp[2][N];
    }
    
    static Long way(int l,int b){
        if((l==2 && b==1) || (l==1 && b==2))
             {dp[l][b]=1L;
              return dp[l][b];
             }
        if(dp[l][b]!=0) return dp[l][b];
        else if(l<2){
            dp[l][b]=way(2,b-2)%1000000007;
            return dp[l][b];
        }
        else{
           dp[l][b]= (way(2,b-1)+way(1,b))%1000000007;
           return dp[l][b];
        }
    }
};


