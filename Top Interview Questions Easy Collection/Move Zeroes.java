/*Problem:
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.   */

//My Solution(0 ms)
class Solution {
    public void moveZeroes(int[] nums) {
        int[] a=new int[nums.length];int j=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0 && j==Integer.MIN_VALUE)  {j=i;}
            else if(j!=Integer.MIN_VALUE && nums[i]!=0)  
            {int t=nums[i];nums[i]=nums[j];nums[j]=t;j++;}
        }
    }
}

//Solution
class Solution {
   public void moveZeroes(int[] nums) {
    int zero = 0, l = 0, r = nums.length;
    while (l < r) {
        if (nums[l] != 0) {
            int tmp = nums[zero];
            nums[zero++] = nums[l];
            nums[l] = tmp;
        }
        l++;
    }
}}
