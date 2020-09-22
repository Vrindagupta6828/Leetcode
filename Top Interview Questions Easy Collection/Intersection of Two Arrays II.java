/* Problem:
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

//My Solution(6 ms)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int min=Math.min(nums1.length,nums2.length);
        int p=-1;
        List<Integer> res=new ArrayList<>();
        if(nums1.length<nums2.length) {
            for(int i=0;i<min;i++){
                for(int j=0;j<nums2.length;j++){
                    if(nums1[i]==nums2[j])
                {   
                    res.add(nums1[i]);
                  nums2[j]=Integer.MAX_VALUE;break;}    
            }
        }}
          else{
              for(int i=0;i<min;i++){
                for(int j=0;j<nums1.length;j++)
                  {   if(nums1[j]==nums2[i])
                         {
                    res.add(nums2[i]);
                         nums1[j]=Integer.MAX_VALUE;break;}  } 
        }}int[] a=new int[res.size()];
        for(int i=0;i<res.size();i++){
            a[i]=res.get(i);
        }
        return a;
    }
}

//Solution(2 ms 98%)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       if(nums1.length>nums2.length) return intersect(nums2,nums1);
        
        HashMap<Integer,Integer> s=new HashMap<>();
        for(int i:nums1) s.put(i,s.getOrDefault(i,0)+1);
        List<Integer> a=new ArrayList<>();
        for(int i:nums2){
            int count=s.getOrDefault(i,0);
            if(count>0){
                a.add(i);
                s.put(i,count-1);
            }
        }
       int[] ans=new int[a.size()];int p=0;
       for(int n:a){ ans[p++]=n;}
        return ans;
    }
}
