/*Question:
Let's call an array arr a mountain if the following properties hold:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]
Given an integer array arr that is guaranteed to be a mountain, return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

 

Example 1:

Input: arr = [0,1,0]
Output: 1
Example 2:

Input: arr = [0,2,1,0]
Output: 1
Example 3:

Input: arr = [0,10,5,2]
Output: 1
Example 4:

Input: arr = [3,4,5,1]
Output: 2
Example 5:

Input: arr = [24,69,100,99,79,78,67,36,26,19]
Output: 2
 

Constraints:

3 <= arr.length <= 104
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.   */

//Solution(o(log n))
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid>0 && mid<arr.length-1)
            { if (arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1])
                  return mid;
              else if(arr[mid-1]>arr[mid])
                  high=mid-1;
              else
                  low=mid+1;
            }
            else if(mid==0){
                if(arr[0]>arr[1])  return 0;
                else return 1;
            }
            else if(mid==arr.length-1){
                if(arr[arr.length-1]>arr[arr.length-2]) return arr.length-1;
                return arr.length-2;
            }
    }
        return -1;
}
}
