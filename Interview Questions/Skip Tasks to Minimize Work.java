/* Question:
You are given a list of integers nums representing tasks that you must get through in order. Each value represents the amount of time it takes to finish that task. Given that you can skip tasks as long as you don’t skip twice in a row, return the minimum time it takes to get through all the tasks.

Constraints

n ≤ 100,000 where n is the length of nums.
Example 1
Input
nums = [10, 5, 7, 15]
Output
12
Explanation
We can skip the first and last tasks.

Example 2
Input
nums = [10, 20]
Output
10
Explanation
We can skip the last task.   */

//Solution (o(n))
class Solution {
    public int solve(int[] nums) {
        int n=nums.length;
        if(n==0 || n==1) return 0;
        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=nums[1];
        for(int i=2;i<n;i++){
             dp[i]=Math.min(dp[i-1]+nums[i],
                     dp[i-2]+nums[i]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}
