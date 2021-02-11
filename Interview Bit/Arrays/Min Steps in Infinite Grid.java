/* Question:
You are in an infinite 2D grid where you can move in any of the 8 directions

 (x,y) to 
    (x+1, y), 
    (x - 1, y), 
    (x, y+1), 
    (x, y-1), 
    (x-1, y-1), 
    (x+1,y+1), 
    (x-1,y+1), 
    (x+1,y-1) 
You are given a sequence of points and the order in which you need to cover the points.. Give the minimum number of steps in which you can achieve it. You start from the first point.

NOTE: This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.



Input Format
Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.



Output Format
Return an Integer, i.e minimum number of steps.



Example Input
Input 1:

 A = [0, 1, 1]
 B = [0, 1, 2]


Example Output
Output 1:

 2


Example Explanation
Explanation 1:

 Given three points are: (0, 0), (1, 1) and (1, 2).
 It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).   */
 
 //Solution 1(O(n))
 public class Solution {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {

        int ans=0;
        for(int i=1,curr=0;curr<A.size()-1 && i<A.size();i++,curr++)
        {   int x0=A.get(curr),y0=B.get(curr);
            int x1=A.get(i),y1=B.get(i);
            int xdiff=Math.abs(x1-x0),ydiff=Math.abs(y1-y0); //find distance between 2 pnts x1,y1 and x0,y0 as path is already given just traverse it
            ans+=Math.max(xdiff,ydiff);
        }
        return ans;
    }
}
