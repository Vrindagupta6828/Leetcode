/* Problem
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 

Example 1:

Input: [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:

Input: [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:

Input: [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 

Note:

You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other. */

//Solution(3 ms 68% time and 73% memory)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals==null || intervals.length==0) return 0;
        else
        { Arrays.sort(intervals, (a,b) -> a[1]-b[1]);
          int endtime=intervals[0][1];int res=0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=endtime) {endtime=intervals[i][1]; continue;}
            res++;
        }
        return res;
    }}
}

//Solution(1 ms 99.82% time & 73% memory)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, new myComparator());
        int start = intervals[intervals.length-1][0];
        int count = 1;
        for(int i = intervals.length-2; i >= 0; i--){
            if(start >= intervals[i][1]){
                start = intervals[i][0];
                count++;
            }
        }
        return intervals.length - count;
    }
    
    class myComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            return a[0] - b[0];
        }
    }
}
