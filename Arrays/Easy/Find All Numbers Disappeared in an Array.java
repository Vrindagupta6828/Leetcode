/* Problem:
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]   */

//Solution 1(o(n) time and space)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       List<Integer> ans=new ArrayList<>();
       int[] a=new int[nums.length+1];
       for(int i=0;i<nums.length;i++){
           a[nums[i]]+=1;
       }
       for(int i=1;i<a.length;i++){
           if(a[i]==0)  ans.add(i);
       }
        return ans;
    }
}

//Solution 2(o(n) time and o(1) space)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       List<Integer> ans=new ArrayList<>();
       for(int i=0;i<nums.length;i++){
           while(nums[nums[i]-1]!=nums[i]) {
               int temp=nums[nums[i]-1];
               nums[nums[i]-1]=nums[i];
               nums[i]=temp;
           }
       }
       for(int i=0;i<nums.length;i++){
           if(nums[i]!=i+1)  ans.add(i+1);
       }
        return ans;
    }
}

//Solution 3 (o(n) time and o(1) space)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       List<Integer> ans=new ArrayList<>();
       for(int i=0;i<nums.length;i++){
               int val=Math.abs(nums[i]);
               nums[val-1]=-1*Math.abs(nums[val-1]);
           }
       for(int i=0;i<nums.length;i++){
           if(nums[i]>0)  ans.add(i+1);
       }
        return ans;
    }
}
