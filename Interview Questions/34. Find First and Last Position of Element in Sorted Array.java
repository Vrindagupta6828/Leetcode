/* Question:
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109   */

//Solution (o(target))
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        ans[0]=-1;ans[1]=-1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==target && ans[0]==-1)
            {    ans[0]=i; ans[1]=i;
            while(i<n-1 && nums[i+1]==target){
                i++; ans[1]++;}
            break;}
            if(nums[i]>target) break;
        }
        return ans;
    }
}

//Solution 2 (o(log n))
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        ans[0]=lowerbound(nums,target);
        ans[1]=(ans[0]==-1)?-1:higherbound(nums,target);
        return ans;
    }
    
    public int lowerbound(int[] nums,int target){
        int start=0,end=nums.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]<target) start=mid+1;
            else if(nums[mid]==target){end=mid-1;ans=mid;}
            else end=mid-1;
        }
        return ans;
    }
    
     public int higherbound(int[] nums,int target){
        int start=0,end=nums.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]<target) start=mid+1;
            else if(nums[mid]==target){start=mid+1;ans=mid;}
            else end=mid-1;
        }
        return ans;
    }
    
    
}
