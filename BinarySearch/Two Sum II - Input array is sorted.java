/*Question
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
 

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
 

Constraints:

2 <= nums.length <= 3 * 104
-1000 <= nums[i] <= 1000
nums is sorted in increasing order.
-1000 <= target <= 1000   */

//Solution1 (o(log n))
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans=new int[2];
        int index1=binarysearch(numbers,target,0,numbers.length-1);
        int index2=binarysearch2(numbers,target-numbers[index1],index1);
        while(index2==-1) {index1=binarysearch(numbers,target,0,index1-1);
                          index2=binarysearch2(numbers,target-numbers[index1],index1);}
        ans[0]=Math.min(index1,index2)+1;ans[1]=Math.max(index1,index2)+1;
        return ans;
    }
    public int binarysearch(int[] nums,int target,int low,int high){
        int res=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>target)
                high=mid-1;
            else{
                res=mid;
                low=mid+1;
            }
        }
        return res;
    }
    public int binarysearch2(int[] nums,int target,int index1){
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) {
                  if(mid==index1)
                  {if(nums[mid-1]==target)
                          return mid-1;}
                  return mid;
            }
            else if(nums[mid]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
}

//Solution2 o(nlogn)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int []  res = new int [2];
        int deficit = 0;
        for(int k = 0; k<numbers.length; k++){
            deficit = target - numbers[k];//get the number i should look for to complete the two sum
            int index = binarySearch(numbers, deficit, k+1, numbers.length-1);//search the rest of the array, step ahead to avoid searching a duplicate
            if(index > -1){
                res[0] = k+1;//increment by one because of one- based indexing
                res[1] = index+1;
                break;
            }
        }
        return res;
    }
    private int binarySearch(int [] arr, int x, int start, int end){//binary search for a region in an array
        int mid = 0;
        while(start<=end){
            mid = (start+end)/2;
            if(arr[mid] > x)
                end = mid-1;
            else if(arr[mid] < x)
                start = mid+1;
            else
                return mid;
        }
        return -1;
    }
}
