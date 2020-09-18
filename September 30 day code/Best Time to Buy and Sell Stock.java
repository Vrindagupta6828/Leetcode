/* Problem:
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.   */

//My Solution
class Solution {
    public int maxProfit(int[] prices) {
        int maxp=0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]-prices[i]>maxp)
                    maxp=prices[j]-prices[i];
            }
        }
        return maxp;
    }
}

//Solution
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        // dp to maintain the highest price from right
        int[] dp = new int[prices.length];
        dp[prices.length-1] = prices[prices.length-1];
        for(int i = prices.length - 2; i >= 0; i--) {
            dp[i] = Math.max(prices[i], dp[i+1]);
        }
        int max = 0;
        for(int i = 0; i < prices.length; i++) {
            int currMax = dp[i] - prices[i];
            max = Math.max(currMax, max);
        }
        return max;
    }
}
