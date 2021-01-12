/* Question:
Given an array nums sorted in ascending order, return true if and only if you can split it into 1 or more subsequences such that each subsequence consists of consecutive integers and has length at least 3.

 

Example 1:

Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3
3, 4, 5
Example 2:

Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3, 4, 5
3, 4, 5
Example 3:

Input: [1,2,3,4,4,5]
Output: False
 

Constraints:

1 <= nums.length <= 10000 */

//Solution(O(n) time and space)
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> fm=new HashMap<>();
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i:nums)
            fm.put(i,fm.getOrDefault(i,0)+1);
        for(int i:nums){
            if(fm.get(i)==0)
                continue;
            if(hm.getOrDefault(i,0)>0){
                hm.put(i,hm.get(i)-1);
                hm.put(i+1,hm.getOrDefault(i+1,0)+1);
                fm.put(i,fm.get(i)-1);
            }
            else if(fm.getOrDefault(i,0)>0 && fm.getOrDefault(i+1,0)>0 &&
                   fm.getOrDefault(i+2,0)>0)
            {  fm.put(i,fm.get(i)-1);
               fm.put(i+1,fm.get(i+1)-1);
               fm.put(i+2,fm.get(i+2)-1);
               hm.put(i+3,hm.getOrDefault(i+3,0)+1);
            }
            else
                return false;
        }
        return true;
    }
}
