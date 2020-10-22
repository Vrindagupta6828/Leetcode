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

//Solution(o(n))
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++)
        {
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums2.length;i++)
        {
            if(map.containsKey(nums2[i]))
            {
                if(map.get(nums2[i])>0)
                {
                     list.add(nums2[i]);
                    map.put(nums2[i],map.get(nums2[i])-1);
                }
               
            }
            
        }
        int res[] = new int[list.size()];
        int i=0;
        for(int a:list)
        {
           res[i++]=a; 
        }
        return res;
    }
}

//Solution 2(binary search)
class Solution {
    Set<Integer> seen = new HashSet<>();
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); Arrays.sort(nums2);
        int n1 = nums1.length, n2 = nums2.length;
        List<Integer> v = new ArrayList<>();
        for(int i=0;i<n1;i++){
             int pos = binarySearch(nums2,0,n2-1,nums1[i]);
             if(pos>=0){
                 v.add(nums1[i]);
                 seen.add(pos);
             }
        }
        int[] ans = new int[v.size()];
        int i=0;for(int val : v) ans[i++] = val;
        return ans;
    }
    
    int binarySearch(int[] arr, int lo, int hi, int key){
        if(lo>hi) return -1;
        int mid = lo + (hi-lo)/2;
        if(arr[mid] == key && seen.contains(mid)){
         int x =  binarySearch(arr,lo,mid-1,key);
         if(x != -1) return x;
         return binarySearch(arr,mid+1,hi,key);
        }
        if(arr[mid] == key) return mid;
        if(arr[mid] > key) return binarySearch(arr,lo,mid-1,key);
        return binarySearch(arr,mid+1,hi,key);
    }
}

//Solution 3(2 pointer)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); Arrays.sort(nums2);
        int n1= nums1.length, n2= nums2.length;
        int i=0,j=0;
        List<Integer> v = new ArrayList<>();
        while(i<n1 && j<n2){
            if(nums1[i] == nums2[j]){
                v.add(nums1[i]);
                i++; j++;
            }
            else if(nums1[i] < nums2[j]) i++;
            else j++;
        }
        int[] ans = new int[v.size()];
        int k=0;for(int val : v) ans[k++] = val;
        return ans;
    }
}
