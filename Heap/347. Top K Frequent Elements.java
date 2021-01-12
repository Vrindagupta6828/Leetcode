/* Question:
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.  */

//Solution(o(nlogk) time and o(n) space)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int num:nums)
            freq.put(num,freq.getOrDefault(num,0)+1);
        PriorityQueue<Integer> pq=new PriorityQueue<>(
        (a,b)->freq.get(a)-freq.get(b));
        for(int num:freq.keySet()){
            pq.add(num);
            if(pq.size()>k)
                pq.poll();
        }
        int p=pq.size();
        int[] ans=new int[p];
        while(!pq.isEmpty()){
            ans[--p]=pq.poll();
        }
        return ans;
    }
}
