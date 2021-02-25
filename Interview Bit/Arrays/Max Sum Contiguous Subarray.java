/* Question:
Find the contiguous subarray within an array, A of length N which has the largest sum.

Input Format:

The first and the only argument contains an integer array, A.
Output Format:

Return an integer representing the maximum possible sum of the contiguous subarray.
Constraints:

1 <= N <= 1e6
-1000 <= A[i] <= 1000
For example:

Input 1:
    A = [1, 2, 3, 4, -10]

Output 1:
    10

Explanation 1:
    The subarray [1, 2, 3, 4] has the maximum possible sum of 10.

Input 2:
    A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

Output 2:
    6

Explanation 2:
    The subarray [4,-1,2,1] has the maximum possible sum of 6. */

//Solution(Kadane's algorithm o(n) time)
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        int maxsum=Integer.MIN_VALUE,max_ending_here=0;
        int n=A.size();
        
        for(int i=0;i<n;i++){
            max_ending_here+=A.get(i);
            if(max_ending_here>maxsum)
                maxsum=max_ending_here;
            if(max_ending_here<0)
               max_ending_here=0;
        }
        return maxsum;
    }
}