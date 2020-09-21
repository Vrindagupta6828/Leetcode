/* Problem:
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4   */

//My Solution(80% space)
class Solution {
    public int singleNumber(int[] nums) {
      List<Integer> a=new ArrayList<Integer>();
        int total=0,total2=0;
      for(int x: nums){
          if(!a.contains(x))
          {a.add(x); total2+=x;}
          total+=x;
      } 
        return (2*total2-total);
    }
}

Solution( 0 ms 100% time and 50% memory)
class Solution {
    public int singleNumber(int[] nums) {
        int x = nums[0];
	    for (int i = 1; i < nums.length;i=i+1) {
            x=x^nums[i];
            }
		return x;       
	    }
	    
}


// [4,1,2,1,2]  ^ is Bitwise XOR
// x^x = 0 x^y^x = 0
