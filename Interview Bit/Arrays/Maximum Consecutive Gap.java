/* Question:
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Example :

Input : [1, 10, 5]
Output : 5 
Return 0 if the array contains less than 2 elements.

You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.   */

//Solution 1(o(nlogn))
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maximumGap(final int[] A) {
        ArrayList<Integer> a=new ArrayList<>();
        int n=A.length;
        
        if (n==1) return 0;
        if (n==2) return Math.abs(A[0]-A[1]);
        
        for(int i=0;i<n;i++){
            a.add(A[i]);
        }
        
        Collections.sort(a);
        int ans=a.get(1)-a.get(0);
        for(int i=1;i<n-1;i++){
            ans=Math.max(ans,a.get(i+1)-a.get(i));
        }
        return ans;
    }
}

