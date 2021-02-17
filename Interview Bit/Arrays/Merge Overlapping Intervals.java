/* Question:
Given a collection of intervals, merge all overlapping intervals.

For example:

Given [1,3],[2,6],[8,10],[15,18],

return [1,6],[8,10],[15,18].

Make sure the returned intervals are sorted.  */

//Solution
**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
          int n=intervals.size();
          ArrayList<Interval> ans=new ArrayList<>();
          Collections.sort(intervals,new Comparator<Interval>(){
              @Override
              public int compare(Interval i1,Interval i2) {
                  return i1.start-i2.start;
              }
          });
          
          Interval current=intervals.get(0);
          
         
          for(int i=1;i<n;i++){
              Interval check=intervals.get(i);
              if(current.end<check.start)
                {   ans.add(current);
                    current=check;
                }
              else
                { current.start=Math.min(current.start,check.start);
                  current.end=Math.max(current.end,check.end);
                } 
          }  
           
          ans.add(current);      
          return ans;
    }
}

//Solution 2
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
          int n=intervals.size();
          ArrayList<Interval> ans=new ArrayList<>();
          Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
          
          Interval current=intervals.get(0);
          
         
          for(int i=1;i<n;i++){
              Interval check=intervals.get(i);
              if(current.end<check.start)
                {   ans.add(current);
                    current=check;
                }
              else
                current.end=Math.max(current.end,check.end);
          }  
           
          ans.add(current);      
          return ans;
    }
}

