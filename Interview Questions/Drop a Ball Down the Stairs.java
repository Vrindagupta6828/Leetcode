/* Question:
You are given an integer height and a list of integers blacklist. You are currently standing at height height and you are playing a game to move a small ball down to height 0.

In even rounds (0, 2, 4, 6 etc.) you can move the ball down 1, 2, or 4 stairs down. In odd rounds, you can move the ball down 1, 3, or 4 stairs. There are some levels of the stairs where if the ball lands there, it will die as labelled in blacklist. Return number of ways you can move the ball down to height 0. Mod the result by 10 ** 9 + 7.

Constraints

1 ≤ height ≤ 100,000
0 ≤ b ≤ 100,000 where b is the length of blacklist
Example 1
Input
height = 4
blacklist = [2]
Output
2
Explanation
We can move 4 stairs down on round 0.
We can move 1 stair down on round 0 and then 3 stairs down on round 1.
Example 2
Input
height = 5
blacklist = [0]
Output
0
Explanation
There's no way to reach height 0 since it's on the blacklist.   */

//Solution
import java.util.*;

class Solution {
    int ans=0;
    int mod=1000000007;
    long[][] temp;
    public int solve(int height, int[] blacklist) {

         HashSet<Integer> blck=new HashSet<>();
         for(int i=0;i<blacklist.length;i++){
             blck.add(blacklist[i]);
         }

         if(blck.contains(0)) return 0;
         temp=new long[height+1][2];
         for(int i=0;i<=height;i++)
         Arrays.fill(temp[i],-1L);
         return (int)(recur(height,blck,0));

    }

    public long recur(int h,HashSet<Integer> blck,
        int odd){
          if(h<0 || blck.contains(h)) return 0L;
          if(h==0) return 1L;
          if(temp[h][odd]!=-1) return temp[h][odd];
          
          if(odd==1){
              temp[h][odd]= (recur(h-1,blck,0)%mod+
                recur(h-3,blck,0)%mod
                +recur(h-4,blck,0)%mod)%mod;
          }

        else{
            temp[h][odd]=(recur(h-1,blck,1)%mod+
              recur(h-2,blck,1)%mod+
              recur(h-4,blck,1)%mod)%mod;
        }
         
         return temp[h][odd]%mod;
    }
}
