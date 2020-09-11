/* Problem:
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.  */

//My Solution (97% in memory better)
class Solution {
    public int maxProduct(int[] nums) {int max=nums[0];
        for(int i=0;i<nums.length;i++){
            int product=nums[i];int t=product;
            for(int j=i+1;j<nums.length;j++){
                t=t*nums[j];
                if(t>product) product=t;
            }if(product>max) max=product;
        }return max;
    }
}

//Solution( 100% in time and 77% in memory o ms)

class Solution {
    public int maxProduct(int[] nums) {
        int product = 1; 
        int maxProduct = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++){
            product *= nums[i];
            maxProduct = Math.max(maxProduct, product);
            if (product == 0){
                product = 1;
            }
        }
        
        product = 1; 
        for (int i = nums.length - 1; i >= 0; i--){
            product *= nums[i];
            maxProduct = Math.max(maxProduct, product);
            if (product == 0){
                product = 1;
            }
        }
        
        return maxProduct;
    }
}
