/* Question:
You are given a list of integers piles and an integer k. piles[i] represents the number of bananas on pile i. On each hour, you can choose any pile and eat r number of bananas in that pile. If you pick a pile with fewer than r bananas, it still takes an hour to eat the pile.

Return the minimum r required such that you can eat all the bananas in less than or equal to k hours.

Constraints

n ≤ 100,000 where n is the length of piles
n ≤ k
Example 1
Input
piles = [6, 4, 3]
k = 5
Output
3
Explanation
At r = 3 bananas per hour, we can eat the first pile in 2 hours, eat the second in 2 hours, and eat the last pile in 1 hour. */

//Solution
import java.util.*;

class Solution {
    int chnge;
    public int solve(int[] piles, int k) {
        int start=1,end=10000,ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            boolean b=check(piles,mid,k);
            if(b) {ans=mid; end=mid-1;}
            else  {start=mid+1;}
        }
        return ans;
    }

    public boolean check(int[] piles,int r,int k){
        int c=0;
        for(int i=0;i<piles.length;i++){
            c=(piles[i]%r==0)?piles[i]/r:piles[i]/r+1;
            if(k<c) return false;
            else k-=c;
        }
        if(k<0)  return false;
        else return true;
    }
}
