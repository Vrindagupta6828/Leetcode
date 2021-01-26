/* Question:
Given an array of positive integers. Find the maximum length of Bitonic subsequence. 
A subsequence of array is called Bitonic if it is first increasing, then decreasing.
 

Example 1:

Input: nums = [1, 2, 5, 3, 2]
Output: 5
Explanation: The sequence {1, 2, 5} is
increasing and the sequence {3, 2} is 
decreasing so merging both we will get 
length 5.

Example 2:

Input: nums = [1, 11, 2, 10, 4, 5, 2, 1]
Output: 6
Explanation: The bitonic sequence 
{1, 2, 10, 4, 2, 1} has length 6.
 

Your Task:
Your don't need to read or print anything. Your task is to complete the function LongestBitonicSequence() which takes the array nums[] as input parameter and returns the maximum length of bitonic subsequence.
 

Expected Time Complexity: O(n2)
Expected Space Complexity: O(n)
 

Constraints:
1 <= length of array <= 200
1 <= arr[i] <= 1000000   */

//Solution(o(n*2) time and o(n) space)
class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int n=nums.length;
        int[] lis=new int[n];
        int[] lds=new int[n];
        
        Arrays.fill(lis,1);
        Arrays.fill(lds,1);
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && lis[i]<lis[j]+1)
                    lis[i]=lis[j]+1;
            }
        }
        
        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(nums[i]>nums[j] && lds[i]<lds[j]+1)
                     lds[i]=lds[j]+1;
            }
        }
        
        int max=lis[0]+lds[0]-1;
        for(int i=1;i<n;i++)
           max=Math.max(max,lis[i]+lds[i]-1);
        return max;
    }
}
