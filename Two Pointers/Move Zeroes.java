/* Question:
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

1.You must do this in-place without making a copy of the array.
2.Minimize the total number of operations.  */

//Solution 1(O(n) time and O(1) space)
class Solution {
    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        while(i<nums.length && j<nums.length){
            if(nums[j]!=0){
                int x=nums[i];
                nums[i]=nums[j];
                nums[j]=x;
                i++;}
            j++;
        }
    }
}

//Solution 2(O(n) time and O(1) space)
void moveZeroes(vector<int>& nums) {
    int lastNonZeroFoundAt = 0;
    // If the current element is not 0, then we need to
    // append it just in front of last non 0 element we found. 
    for (int i = 0; i < nums.size(); i++) {
        if (nums[i] != 0) {
            nums[lastNonZeroFoundAt++] = nums[i];
        }
    }
 	// After we have finished processing new elements,
 	// all the non-zero elements are already at beginning of array.
 	// We just need to fill remaining array with 0's.
    for (int i = lastNonZeroFoundAt; i < nums.size(); i++) {
        nums[i] = 0;
    }
}
