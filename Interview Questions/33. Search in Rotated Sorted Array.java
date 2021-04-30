/* Question:
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104
 

Follow up: Can you achieve this in O(log n) time complexity?  */

//Solution
class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length,i=0,j=n-1;
        if(n==1) return (nums[0]==target)?0:-1;
        
        int k=-1;
        
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[i]<=nums[j]) {k=i; break;}
            if(nums[(mid+n-1)%n]>nums[mid] && nums[(mid+1)%n]>nums[mid])
            {    k=mid;
                break;}
            else if(nums[i]<=nums[mid]) i=mid+1;
            else if(nums[j]>=nums[mid]) j=mid-1;
        }
        int ans=bs(0,k-1,nums,target);
        return (ans==-1)?bs(k,n-1,nums,target):ans;     
    }
    
    public int bs(int start,int end,int[] nums,int target){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                start=mid+1;
            else end=mid-1;
        }
        return -1;
    }
}
