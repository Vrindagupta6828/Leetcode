/* Question:
Given an unsorted integer array, find the first missing positive integer.

Example:

Given [1,2,0] return 3,

[3,4,-1,1] return 2,

[-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.   */

//Solution 1(o(nlogn) time and o(1) space)

public class Solution {
    public int firstMissingPositive(ArrayList<Integer> A) {
        Collections.sort(A);
        int ans=1;
        for(int i=0;i<A.size();i++)
        {
            if(A.get(i)>ans)
                break;
            else if(A.get(i)==ans)
                ans++;
        }
        return ans;
    }
}

//Solution 2(o(n) time and space)
public class Solution {
    public int firstMissingPositive(ArrayList<Integer> A) {
        HashSet<Integer> n=new HashSet<>();
        for(int i=0;i<A.size();i++){
            if(A.get(i)>0)
               n.add(A.get(i));
        }
        
        int ans=1;
        while(n.contains(ans))
           ans++;
        
        return ans;
    }
}
