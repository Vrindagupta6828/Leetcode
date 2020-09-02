/* Problem
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false */

//Solution

//my solution (2,147,483,647-largest integer no. which even given to math.abs if negative remains negative so use long)

import java.lang.Math;
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
       for(int i=0;i<nums.length-1;i++){
           for(int j=i+1;j<nums.length;j++){
               if(Math.abs((long)nums[i]-(long)nums[j])<=t && j-i<=k)
                   return true;
               else if(j-i>k)  break;
           } }
      return false;  
    }}
    
//better than 78% (16ms) (ceiling gives the smallest number larger than or equal to given number and floor gives largest number smaller than pr equal to the given number)

import java.util.*;

class Solution {


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> window = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long curEl = nums[i];
            Long ceiling = window.ceiling(curEl);
            if (ceiling != null && ceiling - curEl <= t) {
                return true;
            }

            Long floor = window.floor(curEl);
            if (floor != null && curEl - floor <= t) {
                return true;
            }
            window.add(curEl);
            if (window.size() > k) {
                window.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
