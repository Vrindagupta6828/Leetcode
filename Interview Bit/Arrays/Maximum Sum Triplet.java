/* Question:
Problem Description

Given an array A containing N integers.

You need to find the maximum sum of triplet ( Ai + Aj + Ak ) such that 0 <= i < j < k < N and Ai < Aj < Ak.

If no such triplet exist return 0.



Problem Constraints
3 <= N <= 105.

1 <= A[i] <= 108.



Input Format
First argument is an integer array A.



Output Format
Return a single integer denoting the maximum sum of triplet as described in the question.



Example Input
Input 1:

 A = [2, 5, 3, 1, 4, 9]
Input 2:

 A = [1, 2, 3]


Example Output
Output 1:

 16
Output 2:

 6


Example Explanation
Explanation 1:

 All possible triplets are:-
    2 3 4 => sum = 9
    2 5 9 => sum = 16
    2 3 9 => sum = 14
    3 4 9 => sum = 16
    1 4 9 => sum = 14
  Maximum sum = 16
Explanation 2:

 All possible triplets are:-
    1 2 3 => sum = 6
 Maximum sum = 6   */
 
 //Solution(o(nlogn))
 public class Solution {

    public int solve(ArrayList<Integer> A) {
        int n=A.size();
        int sum=Integer.MIN_VALUE;
        int[] dp=new int[n];
        int largest=A.get(n-1);
        for(int i=n-2;i>0;i--){
            if(largest>A.get(i))
                  dp[i]=largest;
            else
                {  dp[i]=0;
                   largest=A.get(i);
                }
        }
        
        TreeSet<Integer> set = new TreeSet<>();
		set.add(A.get(0));
		int res = 0;
		for (int i = 1; i < n - 1; i++) {
			Integer lmax = set.lower(A.get(i));
			int rmax = dp[i];
			if (lmax != null && A.get(i) < rmax) {
				res = Math.max(res, lmax + A.get(i) + rmax);
			}
			set.add(A.get(i));
		}
		return res;
        
    }
}
