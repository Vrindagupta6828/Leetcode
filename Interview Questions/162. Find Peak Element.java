/* Question:
A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 

Constraints:

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.
 
 Follow up: Could you implement a solution with logarithmic complexity?  */

//Solution
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid==0){
                if(nums[mid]>nums[mid+1]) return mid;
                else start=mid+1;
            }
            else if(mid==nums.length-1){
                if(nums[mid]>nums[mid-1]) return mid;
                else end=mid-1;
            }
            else if(mid>0 && mid<nums.length-1){
                if(nums[mid]>nums[mid+1] &&
                    nums[mid]>nums[mid-1]) return mid;
                else if(nums[mid]<nums[mid+1]) start=mid+1;
                else end=mid-1;
            }
         }
        return -1;
    }
}

//Solution 2
public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
