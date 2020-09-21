/* Problem:
Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 2 * 10^4
It's guaranteed that nums[i] fits in a 32 bit-signed integer.
k >= 0   */

//Solution(0 ms 100% in time and 73% in space)
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length==0 || nums.length==1) return;
        //Reverse full array
        for(int i=0;i<=(nums.length-1)/2;i++){
            int t=nums[i];
            nums[i]=nums[nums.length-1-i];
            nums[nums.length-1-i]=t;
        }
        //to handle for k value greater than array size
        k=k%nums.length;
        //reverse first k elements
          for(int i=0;i<k/2;i++){
              int t=nums[i];
              nums[i]=nums[k-1-i];
              nums[k-1-i]=t;
        }
        //reverse remaining eleements after k elements
        for(int i=k;i<k+(nums.length-k)/2;i++){
            int t=nums[i];
            nums[i]=nums[nums.length-1+k-i];
            nums[nums.length-1+k-i]=t;
        }       
}
}

//Soltuion(50% in time && 98.78% in space)

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length==0 || nums.length==1) return;
        int[] temp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            temp[i]=nums[nums.length-1-i];
        }
        k=k%nums.length;
          for(int i=0;i<k/2;i++){
              int t=temp[i];
              temp[i]=temp[k-1-i];
              temp[k-1-i]=t;
              //System.out.print(temp[i]+" ");
        }
        /*for(int i=0;i<nums.length;i++){
             System.out.print(temp[i]+" ");
             // temp[i]=nums[i];
        }*/
        for(int i=k;i<k+(temp.length-k)/2;i++){
            int t=temp[i];
            temp[i]=temp[temp.length-1+k-i];
            temp[temp.length-1+k-i]=t;
        }
         for(int i=0;i<nums.length;i++){
           //  System.out.print(temp[i]+" ");
              nums[i]=temp[i];
        }
                
}
}
