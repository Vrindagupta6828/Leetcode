/* Question:
Given an integer array arr, return the length of a maximum size turbulent subarray of arr.

A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:

For i <= k < j:
arr[k] > arr[k + 1] when k is odd, and
arr[k] < arr[k + 1] when k is even.
Or, for i <= k < j:
arr[k] > arr[k + 1] when k is even, and
arr[k] < arr[k + 1] when k is odd.
 

Example 1:

Input: arr = [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
Example 2:

Input: arr = [4,8,12,16]
Output: 2
Example 3:

Input: arr = [100]
Output: 1
 

Constraints:

1 <= arr.length <= 4 * 104
0 <= arr[i] <= 109   */

//Solution 1(o(n^2) time and o(n) space)
class Solution {
    public int maxTurbulenceSize(int[] arr) {
       int flag=0,n=arr.length;
       
       int[] dp=new int[n];
       Arrays.fill(dp,1);
        
       if(n==1)  return 1;

       for(int i=0;i<n;i++){
         for(int j=i+1;j<n;j++){
             if(j==i+1){
                if(arr[i]>arr[j])
                {   flag=1;
                    dp[i]++;
                }
                else if(arr[i]<arr[j])
                {    flag=0;
                     dp[i]++;
                }
                else if(arr[i]==arr[j])
                    break;
             }
             else if(flag==0 && arr[j-1]>arr[j])
             {   dp[i]++;
                 flag=1;
             }
             else if(flag==1 && arr[j]>arr[j-1])
             {    dp[i]++;
                  flag=0;
             }
             else
                 break;
         }
       }
        
      int max=dp[0];
      for(int i=0;i<n;i++)
      {   //System.out.println(dp[i]);
          max=Math.max(max,dp[i]);
      }
      return max;
    }
}

//Solution 2(Sliding window)(O(n) time and o(1) space)
class Solution {
    public int maxTurbulenceSize(int[] A) {
        int N = A.length;
        int ans = 1;
        int anchor = 0;

        for (int i = 1; i < N; ++i) {
            int c = Integer.compare(A[i-1], A[i]);
            if (c == 0) {
                anchor = i;
            } else if (i == N-1 || c * Integer.compare(A[i], A[i+1]) != -1) {
                ans = Math.max(ans, i - anchor + 1);
                anchor = i;
            }
        }

        return ans;
    }
}
