/* Problem:
Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)

We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.

(Note also that a translation does not include any kind of rotation.)

What is the largest possible overlap?

Example 1:

Input: A = [[1,1,0],
            [0,1,0],
            [0,1,0]]
       B = [[0,0,0],
            [0,1,1],
            [0,0,1]]
Output: 3
Explanation: We slide A to right by 1 unit and down by 1 unit.
Notes: 

1 <= A.length = A[0].length = B.length = B[0].length <= 30
0 <= A[i][j], B[i][j] <= 1 */

//Solution (16 ms)

class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int maxCnt = 0;
        for (int x = 0; x < A.length; x++) {
            for (int y = 0; y < A.length; y++) {
                maxCnt = Math.max(shiftCount(x, y, A, B), maxCnt);
                maxCnt = Math.max(shiftCount(x, y, B, A), maxCnt);
            }
        }
        
        return maxCnt;
    }
    
    public int shiftCount(int x, int y, int[][] image1, int[][] image2) {
        int x2 = 0, y2 = 0, cnt = 0;
        
        for (int x1 = x; x1 < image1.length; x1++) {
            y2 = 0;
            for (int y1 = y; y1 < image1.length; y1++) {
                if (image1[x1][y1] == 1 && image1[x1][y1] == image2[x2][y2]) cnt++;
                y2++;
            }
            x2++;
        }
        
        return cnt;
    }
    
}
