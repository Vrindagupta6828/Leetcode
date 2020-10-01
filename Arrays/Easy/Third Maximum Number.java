/* Problem:
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.   */

//My Solution(o(n))
class Solution {
    public int thirdMax(int[] nums) {
        int max=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE,flag=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=max) max=nums[i];
        }
        if(nums.length<3) return max;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<max && nums[i]>=max2) max2=nums[i];
        }
        if(max2==Integer.MIN_VALUE) return max;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<max2 && nums[i]>=max3) {max3=nums[i];flag=1;}
        }
        return ((flag==1)?max3:max);
    }
}

//Solution2
class Solution {
    public int thirdMax(int[] nums) {
        int max=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE,flag=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==Integer.MIN_VALUE)
                flag=1;
            if(max==nums[i] || max2==nums[i] || nums[i]<=max3)
                continue;
            else if(max<nums[i])
            {max3=max2;
            max2=max;
            max=nums[i];}
            else if(max2<nums[i]){
                max3=max2;
                max2=nums[i];
            }
            else
                max3=nums[i];
        }
       if(max2==Integer.MIN_VALUE || (max3==Integer.MIN_VALUE && flag==0)) return max;
        return max3;
    }
}
