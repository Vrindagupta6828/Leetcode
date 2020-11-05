/* Question:
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?  */

//Solution(O(n) time and space)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);Arrays.sort(nums2);
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j])
            { ans.add(nums1[i]); i++;j++;}
            else if(nums1[i]<nums2[j])
                i++;
            else
                j++;
        }
        int[] res= new int[ans.size()];
        i=0;
        for(int n:ans)
            res[i++]=n;
        return res;
    }
}
        
