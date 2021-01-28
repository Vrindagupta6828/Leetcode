/* Question:
A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequences:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7
 
A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of the array A is called arithmetic if the sequence:
A[P], A[P + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.

 
Example:

A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.  */

//Solution(brute force)(o(n^3) time and o(1) space)
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int count=0;
        for(int s=0;s<A.length-2;s++){
            int d=A[s+1]-A[s];
            for(int e=s+2;e<A.length;e++){
                int i=0;
                for(i=s+1;i<=e;i++)
                {    if(A[i]-A[i-1]!=d)
                        break;
                }
                if(i>e)
                    count++;
            }
        }
        return count;
    }
}

//Solution 2(better brute force)(o(n^2) time and o(1) space)(for every s to e we cal arithmetic pair or not then from s to e+1 we again cal s to e so we can just cal e+1
// and e and then add to count if true

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int count=0;
        for(int s=0;s<A.length-2;s++){
            int d=A[s+1]-A[s];
            for(int e=s+2;e<A.length;e++){
                if(A[e]-A[e-1]==d)
                    count++;
                else break;
            }
        }
        return count;
    }
}

//Solution 3(Recursion)(O(n) time and space)
class Solution {
    int sum=0;
    public int numberOfArithmeticSlices(int[] A) {
        slice(A,A.length-1);
        return sum;
    }
    
    public int slice(int[] A,int i){
        if(i<2)  return 0;
        int ap=0;
        if(A[i]-A[i-1]==A[i-1]-A[i-2])
        {   ap=1+slice(A,i-1);
            sum+=ap;}
        else
            slice(A,i-1);
        return ap;
    }
}

//Solution 4(DP)(O(N) time and space)
class Solution {
        public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < dp.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }
}

//Solution 5(Constant space dp)
class Solution {
        public int numberOfArithmeticSlices(int[] A) {
        int dp=0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp = 1 + dp;
                sum += dp;
            }
            else
                dp=0;
        }
        return sum;
    }
}

