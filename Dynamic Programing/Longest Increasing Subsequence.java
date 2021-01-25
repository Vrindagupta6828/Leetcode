/* Question:
Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.

Example 1:

Input:
N = 16
A[]={0,8,4,12,2,10,6,14,1,9,5
     13,3,11,7,15}
Output: 6
Explanation:Longest increasing subsequence
0 2 6 9 13 15, which has length 6
Example 2:

Input:
N = 6
A[] = {5,8,3,7,9,1}
Output: 3
Explanation:Longest increasing subsequence
5 7 9, with length 3
Your Task:
Complete the function longestSubsequence() which takes the input array and its size as input parameters and returns the length of the longest increasing subsequence.

Expected Time Complexity : O( N*log(N) )
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
0 ≤ A[i] ≤ 106  */

// Solution 1(O(n^2))
class Solution { 
    // return length of longest strictly increasing subsequence
    static int longestSubsequence(int size, int a[]){
        // code here\
        int[] count=new int[size];
        
        Arrays.fill(count,1);
        
        for(int i=1;i<size;i++){
            for(int j=0;j<i;j++){
                if(a[i]>a[j] && count[i]<count[j]+1)
                   count[i]=count[j]+1;
            }
        }
        int ans=count[0];
        for(int i=1;i<size;i++)
            ans=Math.max(ans,count[i]);
        return ans;
    }
} 

//Solution 2(o(nlogn))
class Solution { 
    // return length of longest strictly increasing subsequence
    static int longestSubsequence(int size, int a[]){
        // code here
        int[] seq=new int[size];
        int len=1;
        seq[0]=a[0];
        
        for(int i=1;i<size;i++){
            if(a[i]<seq[0])
               seq[0]=a[i];
            else if(a[i]>seq[len-1])
               seq[len++]=a[i];
            else
               seq[ceiltable(seq,-1,len-1,a[i])]=a[i];
        }
        return len;
    }
    
    static int ceiltable(int[] arr,int l,int r,int key){
        while(r-l>1){
            int m=l+(r-l)/2;
            if(arr[m]>=key)
                r=m;
            else
                l=m;
        }
        return r;
    }
} 
