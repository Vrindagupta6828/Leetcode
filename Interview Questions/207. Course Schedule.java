/* Question:
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.  */

//Solution
class Solution {
    ArrayList<ArrayList<Integer>> adj;
    ArrayList<Integer> res;
    int[] in;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj=new ArrayList<>();
        res=new ArrayList<>();
        in=new int[numCourses];
        
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            in[prerequisites[i][0]]++;
        }
        return Kahn(numCourses);
        
    }
    
    public boolean Kahn(int n){
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if (in[i]==0) q.add(i);}
        while(!q.isEmpty()){
            int curr=q.poll();
            res.add(curr);
            for(int node:adj.get(curr)){
                in[node]--;
                if(in[node]==0) q.add(node);
            }        
        }
        if(res.size()<n) return false;
        return true;
    }
}
