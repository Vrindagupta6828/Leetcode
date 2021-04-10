/* Question:
You are given a list of integers nums, and an integer k, which represents a large list of nums concatenated k times. Return the sum of the sublist with the largest sum. The sublist can be empty.

Constraints

0 ≤ n ≤ 100,000 where n is the length of nums.
0 ≤ k ≤ 10,000
Example 1
Input
nums = [1, 3, 4, -5]
k = 1
Output
8
Explanation
We can take the sublist [1, 3, 4]

Example 2
Input
nums = [1, 3, 4, -5]
k = 2
Output
11
Explanation
We can take the sublist [1, 3, 4, -5, 1, 3, 4]  */

//Solution (o(n) time and space)
import java.util.*;

class Solution {
    public int solve(int[] nums, int k) {
        int n=nums.length;
        if(n==0 || k==0) return 0;

        int[] dp=new int[n];
        dp[0]=nums[0];
        int max=Math.max(0,dp[0]);
        
        for(int i=1;i<n;i++){
            dp[i]=Math.max(nums[i],nums[i]+dp[i-1]);
            max=Math.max(max,dp[i]);
        }

        if(k==1) return max;
        
        int[] suffix=new int[n],prefix=new int[n];
        suffix[n-1]=nums[n-1];
        int maxsuff=Math.max(0,suffix[n-1]);
        prefix[0]=nums[0];
        int maxpref=Math.max(0,prefix[0]);

        for(int i=n-2;i>=0;i--){
            suffix[i]=suffix[i+1]+nums[i];
            maxsuff=Math.max(maxsuff,suffix[i]);
        }
        
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
            maxpref=Math.max(maxpref,prefix[i]);
        }

        max=Math.max(max,maxsuff+maxpref);
        max=Math.max(max,max+prefix[n-1]*(k-2));
        return max;
    }
}
