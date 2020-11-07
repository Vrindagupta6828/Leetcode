/* Question:
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
A is sorted in non-decreasing order. */

//Solution 1 (O(n) time and space)
class Solution {
    public int[] sortedSquares(int[] A) {
        int i;
        for(i=0;i<A.length;i++){
            if(A[i]>=0) break;
        }
        int j=i-1,t=0;
        int[] ans=new int[A.length];
        while(j>=0 && i<A.length){
                if(A[j]*A[j]>A[i]*A[i])
                { ans[t++]=A[i]*A[i]; i++;}
                else
                {ans[t++]=A[j]*A[j];
                    j--;}
            }
        while(j>=0){
            ans[t++]=A[j]*A[j];
            j--;
        }
        while(i<A.length){
            ans[t++]=A[i]*A[i];
            i++;
        }
        return ans;
    }
}

//Solution(O(nlogn))
class Solution {
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        for (int i = 0; i < N; ++i)
            ans[i] = A[i] * A[i];

        Arrays.sort(ans);
        return ans;
    }
}
