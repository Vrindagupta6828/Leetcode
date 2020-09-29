/*Problem:
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [0]
Output: 0
Example 4:

Input: nums = [-1]
Output: -1
Example 5:

Input: nums = [-2147483647]
Output: -2147483647
 

Constraints:

1 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1   */

//Solution(o(n) kaden's algorithm)
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==1) return nums[0];
        int left=0,sum=nums[0],ans=nums[0];
        for(int right=1;right<nums.length;right++){
            sum=Math.max(nums[right],sum+nums[right]);
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}

//Divide and conquer(o(nlogn))
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==1) return nums[0];
        int ans=mergehelper(0,nums.length-1,nums);
        return ans;
    }
    
    private int mergehelper(int start,int end,int[] nums){
        if(start>=end) return nums[start];
        int mid=(start+end)/2;
        int lr=mergehelper(start,mid,nums);
        int rr=mergehelper(mid+1,end,nums);
        return helper(nums,mid,start,end,lr,rr);
    }
    
    private int helper(int[] nums,int mid,int start,int end,int lr,int rr){
        int lmax=Integer.MIN_VALUE; int sum=0;
        for(int i=mid;i>=start;i--){
            sum+=nums[i];
            lmax=Math.max(lmax,sum);
        }
        int rmax=Integer.MIN_VALUE;sum=0;
        for(int i=mid+1;i<=end;i++){
            sum+=nums[i];
            rmax=Math.max(rmax,sum);
        }
        
        int cr=rmax+lmax;
        return(Math.max(lr,Math.max(rr,cr)));
    }
}
