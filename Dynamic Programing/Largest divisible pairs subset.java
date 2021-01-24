/* Question:
Given an array of n distinct elements, find length of the largest subset such that every pair in the subset is such that the larger element of the pair is divisible by smaller element. 
Examples: 
 

Input : arr[] = {10, 5, 3, 15, 20} 
Output : 3 
Explanation: The largest subset is 10, 5, 20.
10 is divisible by 5, and 20 is divisible by 10.

Input : arr[] = {18, 1, 3, 6, 13, 17} 
Output : 4
Explanation: The largest subset is 18, 1, 3, 6,
In the subsequence, 3 is divisible by 1, 
6 by 3 and 18 by 6.  */

//Solution 1(o(n*n))
import java.util.Arrays;
 
// Java program to find the largest
// subset which was each pair
// is divisible.
class GFG {
 
    // function to find the longest Subsequence
    static int largestSubset(int[] a, int n)
    {
        // dp[i] is going to store size of largest
        // divisible subset beginning with a[i].
        int[] dp = new int[n];
 
        // Since last element is largest, d[n-1] is 1
        dp[n - 1] = 1;
 
        // Fill values for smaller elements.
        for (int i = n - 2; i >= 0; i--) {
 
            // Find all multiples of a[i] and consider
            // the multiple that has largest subset
            // beginning with it.
            int mxm = 0;
            for (int j = i + 1; j < n; j++) {
                if (a[j] % a[i] == 0 || a[i] % a[j] == 0) {
                    mxm = Math.max(mxm, dp[j]);
                }
            }
 
            dp[i] = 1 + mxm;
        }
 
        // Return maximum value from dp[]
        return Arrays.stream(dp).max().getAsInt();
    }
 
    // driver code to check the above function
    public static void main(String[] args)
    {
        int[] a = { 1, 3, 6, 13, 17, 18 };
        int n = a.length;
        System.out.println(largestSubset(a, n));
    }
}

//to print
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> a=new ArrayList<>();
        int n=nums.length;
        int[] dp=new int[n];
        dp[n-1]=1;
        ArrayList<Integer> u=new ArrayList<>();
        u.add(nums[n-1]);
        a.add(u);
        for(int i=n-2;i>=0;i--){
            int max=0;
            int ind=-1;
            for(int j=i+1;j<n;j++){
                if(nums[j]%nums[i]==0 || nums[i]%nums[j]==0){
                    if(max<dp[j])
                    {ind=j;max=dp[j];}
                }
            }
            dp[i]=1+max;
            ArrayList<Integer> t=new ArrayList<>();
            t.add(nums[i]);
            if(ind!=-1){
                ArrayList<Integer> temp=a.get(n-1-ind);
                for(int x:temp)
                    t.add(x);
            }
            a.add(t);
        }
        int max=0,ind=-1;
        for(int i=0;i<n;i++){
            if(dp[i]>max){
                max=dp[i];
                ind=i;
            }
        }
        
        return a.get(n-1-ind);
    }
}

