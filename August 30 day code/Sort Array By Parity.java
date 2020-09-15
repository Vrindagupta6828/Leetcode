/* Problem:
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 

Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000   */

//My Solution(1 ms 99.58% in time 65% in memory)

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] ans=new int[A.length];
        List<Integer> odd=new ArrayList<>();
        int p=0;
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0) {ans[p++]=A[i];}
            else  odd.add(A[i]);
        }
        for(int j=0;j<odd.size();j++){
            ans[p++]=odd.get(j);
        }
        return ans;
    }
}

