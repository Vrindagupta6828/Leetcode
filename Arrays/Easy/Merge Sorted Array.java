/* Problem:
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 

Constraints:

-10^9 <= nums1[i], nums2[i] <= 10^9
nums1.length == m + n
nums2.length == n  */

//My Solution(o(n^2) insertion sort)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){
            int j=m-1;
            while(j>=0 && nums2[i]<nums1[j]){
                nums1[j+1]=nums1[j];nums1[j]=nums2[i];
                j--;
            }
            m++;
            nums1[j+1]=nums2[i];
        }
    }
}

//Solution(O(nlogn))
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr = 0;
        for(int i=m;i<nums1.length;i++)
        {
            nums1[i] = nums2[ptr];
            ptr++;
        }
        Arrays.sort(nums1);
    }
}
