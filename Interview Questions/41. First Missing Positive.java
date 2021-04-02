/* Question:
Given an unsorted integer array nums, find the smallest missing positive integer.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
 

Constraints:

0 <= nums.length <= 300
-231 <= nums[i] <= 231 - 1
 

Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space?   */

//Solution 1(o(n) time and space)
class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> freq=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            freq.add(nums[i]);
        }
        int ans=1;
        while(freq.contains(ans))
            ans++;
        return ans;
    }
}

//Solution 2(o(nlogn))
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int ans=1,n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>ans) return ans;
            else if(nums[i]==ans) ans++;
        }
        return ans;
    }
}

//Solution 3(o(n) time and o(1) space)
class Solution {
    public int firstMissingPositive(int[] nums) {
        int index = 0;
        if(nums == null || nums.length == 0){
            return 1;
        }
        while(index < nums.length){
            if(nums[index] >0 && nums[index] <= nums.length && nums[index] != nums[nums[index]-1]){
                swap(nums,index,nums[index]-1);
            }else{
                index++;
            }
        }
        for(int i =0; i< nums.length;i++){
            if(nums[i] <=0 || nums[i] > nums.length){
                return i+1;
            }else if(nums[i]!=i+1){
                return i+1;
            }
        }
        
        return nums.length+1;
   
    
}
     public void swap(int[] nums,int a,int b){
            int temp = nums[a];
            nums[a] =nums[b];
            nums[b] = temp;
        }
}
