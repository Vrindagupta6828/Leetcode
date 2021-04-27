/* Question:
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 

Follow up: The overall run time complexity should be O(log (m+n)).  */

//Solution (o(m+n) time and space)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length,m=nums2.length;
        
        if(n==0 && m==0) return 0.0;
        int[] ans=new int[m+n];
        
        int i=0,j=0,p=0;
        while(i<n && j<m){
            if(nums1[i]<nums2[j])
                ans[p++]=nums1[i++];
            else
                ans[p++]=nums2[j++];
        }
        
        while(i<n)
            ans[p++]=nums1[i++];
        
        while(j<m)
            ans[p++]=nums2[j++];
        
        if((m+n-1)%2==0) return ans[(m+n-1)/2];
        else {
            int t=m+n-1;
            return (ans[(t+1)/2]+ans[(t-1)/2])/2.0;
        }
    }
}
