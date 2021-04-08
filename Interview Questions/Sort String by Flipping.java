/* Question:
You are given a string s consisting of the letters "x" and "y". In addition, you have an operation called flip, which changes a single "x" to "y" or vice versa.

Determine the smallest number of times you would need to apply this operation to ensure that all "x"'s come before all "y"'s.

Constraints

0 ≤ n ≤ 100,000 where n is the length of s
Example 1
Input
s = "xyxxxyxyy"
Output
2
Explanation
It suffices to flip the second and sixth characters.   */

//Solution (o(n) time & space)
import java.util.*;

class Solution {
    public int solve(String s) {
        int n=s.length();
        if(n==0 || n==1) return 0;
        int[] lefty=new int[n],rightx=new int[n];
        lefty[0]=0;rightx[n-1]=0;

        for(int i=1;i<n;i++)
           lefty[i]=lefty[i-1]+
             (s.charAt(i-1)=='y'?1:0);
        
        for(int i=n-2;i>=0;i--)
           rightx[i]=rightx[i+1]+
             (s.charAt(i+1)=='x'?1:0);
        
        int res=n;
        for(int i=0;i<n;i++){
            res=Math.min(res,lefty[i]+rightx[i]);
        }
        return res; 
    }
}
