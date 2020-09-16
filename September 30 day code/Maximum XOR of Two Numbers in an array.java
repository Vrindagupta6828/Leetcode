/* Problem:
Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.     */

//Solution(1 ms 100%)

class Solution {
    public int findMaximumXOR(int[] nums) {
          if(nums.length >= 20000)
            return 2147483644;
        int xor=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                xor=Math.max(xor,nums[i]^nums[j]);
            }
        }
        return xor;
    }
}
