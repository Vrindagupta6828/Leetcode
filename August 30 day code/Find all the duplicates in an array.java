/* Problem:
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3] */

//Solution(beats 100%)

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int[] bucket=new int[nums.length+1];
        List<Integer> a=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            bucket[nums[i]]+=1;
        }
        for(int i=1;i<bucket.length;i++){
            if (bucket[i]>1)  a.add(i);
        }
    return a;
    }
}
