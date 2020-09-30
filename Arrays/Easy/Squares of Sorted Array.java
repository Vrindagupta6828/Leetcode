/*Problem:
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.  */

//My Solution(o(nlog n)
class Solution {
    public int[] sortedSquares(int[] A) {
        for(int i=0;i<A.length;i++){
            A[i]=A[i]*A[i];
        }
        Arrays.sort(A);
        return A;
    }
}

//Solution2(o(n))
class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        
        int j = 0;
        while (j < n && A[j] < 0) {
            j++;
        }
        
        int i = j - 1;
        
        int idx = 0;
        int[] res = new int[n];
        
        while(i >= 0 && j < n) {
            if (A[i]*A[i] < A[j]*A[j]) {
                res[idx++] = A[i]*A[i];
                i--;
            } else {
                res[idx++] = A[j]*A[j];
                j++;
            }
        }
        
        while (i >= 0) {
            res[idx++] = A[i]*A[i];
            i--;
        }

        while (j < n) {
            res[idx++] = A[j]*A[j];
            j++;
        }
        
        return res;
    }
}
