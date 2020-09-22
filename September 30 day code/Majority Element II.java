/*Problem:
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]  */

//My Solution(9 ms 90% in memory)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c=(int)Math.floor(nums.length/3);
        HashMap<Integer,Integer> s=new HashMap<>();
        ArrayList<Integer> a=new ArrayList<>();
        for(int i:nums) s.put(i,s.getOrDefault(i,0)+1);
        
        for(int i:s.keySet()) {if(s.get(i)>c) a.add(i);}
        return a;
    }
}

