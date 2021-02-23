/* Question:
Problem Description

Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].



Input Format
First and only argument is an integer array A.



Output Format
Return an integer denoting the maximum value of j - i;



Example Input
Input 1:

 A = [3, 5, 4, 2]


Example Output
Output 1:

 2


Example Explanation
Explanation 1:

 Maximum value occurs for pair (3, 4).  */
 
 //Solution:
 public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        HashMap<Integer,Integer> pos=new HashMap<>();
        int n=A.size();
        int[] suffix=new int[n];
        
        suffix[n-1] = A.get(n-1);
        for(int i=n-2;i>=0;i--){
            suffix[i]=Math.max(suffix[i+1],A.get(i));
        }
        
       int i=0,j=0,ans=0;
       while(i<n && j<n){
           if(A.get(i)<=suffix[j])
             {   ans=Math.max(ans,j-i);
                 j++;
             }
            else
               i++;
       }
       return ans;
    }
}
