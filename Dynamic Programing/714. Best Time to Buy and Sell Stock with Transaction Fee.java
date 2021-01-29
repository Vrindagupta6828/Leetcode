/* Question:
Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Note:

0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.   */

//Top-Down
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        
        for(int i=1;i<n;i++){
            dp[i][1]=Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
        }
        
        return dp[n-1][0];
    }
}

//Solution 2(Memorise)
class Solution {
    static int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        dp=new int[prices.length+1][2];
        
        for(int i=0;i<dp.length;i++)
        {   dp[i][0]=-1;
            dp[i][1]=-1;
        }
        
        return maxP(prices,0,0,fee);
    }
    
    public int maxP(int[] prices,int i,int leftstock,int fee){
        
        if(i>=prices.length) return 0;
        
        if(dp[i][leftstock]!=-1)
            return dp[i][leftstock];
        
        int temp=0;
        
        if(leftstock==1){
            int sell=prices[i]-fee,notsell=0;
            
            if(dp[i+1][0]!=-1)
                sell+=dp[i+1][0];
            else
                sell+=maxP(prices,i+1,0,fee);
            
            if(dp[i+1][1]!=-1)
                notsell=dp[i+1][1];
            
            else
                notsell=maxP(prices,i+1,1,fee);
            
            temp=Math.max(sell,notsell);
        }
        
        else{
            int buy=-prices[i],notbuy=0;
            
            if(dp[i+1][1]!=-1)
                buy+=dp[i+1][1];
            else
                buy+=maxP(prices,i+1,1,fee);
            
            if(dp[i+1][0]!=-1)
                notbuy=dp[i+1][0];
            else
                notbuy=maxP(prices,i+1,0,fee);
            
            temp=Math.max(buy,notbuy);
        }
        return dp[i][leftstock]=temp;
        
    }
}
