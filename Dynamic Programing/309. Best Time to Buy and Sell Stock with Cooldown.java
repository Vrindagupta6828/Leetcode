/* Question:
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]  */

//Solution 1(memorization)
class Solution {
    static int[][] dp;
    public int maxProfit(int[] prices) {
        dp=new int[prices.length+2][2];
        
        for(int i=0;i<dp.length;i++)
        {   dp[i][0]=-1;
            dp[i][1]=-1;
        }
        
        return maxP(prices,0,0);
    }
    
    public int maxP(int[] prices,int i,int leftstock){
        
        if(i>=prices.length) return 0;
        
        if(dp[i][leftstock]!=-1)
            return dp[i][leftstock];
        
        int temp=0;
        
        if(leftstock==1){
            int sell=prices[i],notsell=0;
            
            if(dp[i+2][0]!=-1)
                sell+=dp[i+2][0];
            else
                sell+=maxP(prices,i+2,0);
            
            if(dp[i+1][1]!=-1)
                notsell=dp[i+1][1];
            
            else
                notsell=maxP(prices,i+1,1);
            
            temp=Math.max(sell,notsell);
        }
        
        else{
            int buy=-prices[i],notbuy=0;
            
            if(dp[i+1][1]!=-1)
                buy+=dp[i+1][1];
            else
                buy+=maxP(prices,i+1,1);
            
            if(dp[i+1][0]!=-1)
                notbuy=dp[i+1][0];
            else
                notbuy=maxP(prices,i+1,0);
            
            temp=Math.max(buy,notbuy);
        }
        return dp[i][leftstock]=temp;
        
    }
}

//Solution(bottom up)
/* dp[len][2]
   case 1 : We have stock on day i , dp[i][1] = max of below
   - I brought it today
        dp[i-2][0] - prices[i]
   - I am carrying it forward
        dp[i-1][1]
   
   case 2 : We have no stock on day i, day[i][0]= max of below
   - I have sold it today
        dp[i-1][1] + prices[i]   
   - I am carrying it forward, doing nothing
        dp[i-1][0]
*/

class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        
        if(n<2) return 0;
        
        if(n==2 && prices[1]>prices[0])
             return prices[1]-prices[0];
        
        if(n==2 && prices[0]>prices[1])
             return 0;
        
        int[][] dp=new int[n][2];
        
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[1][0]=Math.max(dp[0][1]+prices[1],dp[0][0]);
        dp[1][1]=Math.max(dp[0][1],dp[0][0]-prices[1]);
        
        for(int i=2;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][1] + prices[i],dp[i-1][0]);
            dp[i][1]=Math.max(dp[i-2][0] - prices[i],dp[i-1][1]);
        }
        return dp[n-1][0];
    }
}
