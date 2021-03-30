/* Question:
There are a total of n courses you have to take labelled from 0 to n - 1.

Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.

Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.

If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.   */

//Solution
class Solution {
    ArrayList<ArrayList<Integer>> adj;
    ArrayList<Integer> res;
    int[] in;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj=new ArrayList<>();
        res=new ArrayList<>();
        in=new int[numCourses];
        
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            in[prerequisites[i][0]]++;
        }
        
        res=Kahn(numCourses);
        int[] ans=new int[res.size()];
        for(int i=0;i<res.size();i++)
            ans[i]=res.get(i);
        return ans;
    }
    
    public ArrayList<Integer> Kahn(int n){
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        { if(in[i]==0)
             q.add(i);
        }
        
        while(!q.isEmpty()){
            int curr=q.poll();
            res.add(curr);
            for(int node:adj.get(curr)){
                in[node]--;
                if(in[node]==0) q.add(node);
            }
        }
        if(res.size()<n) return new ArrayList<Integer>();
        return res;
    }
}
