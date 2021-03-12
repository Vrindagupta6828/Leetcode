/* Question:
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1, and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

 

Example 1:


Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Example 2:


Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
Example 3:

Input: graph = [[1],[]]
Output: [[0,1]]
Example 4:

Input: graph = [[1,2,3],[2],[3],[]]
Output: [[0,1,2,3],[0,2,3],[0,3]]
Example 5:

Input: graph = [[1,3],[2],[3],[]]
Output: [[0,1,2,3],[0,3]]
 

Constraints:

n == graph.length
2 <= n <= 15
0 <= graph[i][j] < n
graph[i][j] != i (i.e., there will be no self-loops).
The input graph is guaranteed to be a DAG.   */

//Solution 1(Backtracking)
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> temp=new ArrayList<>();
        ans=new ArrayList<>();
        temp.add(0);
        solve(graph,0,temp,ans);
           return ans;
    }
    
    private boolean solve(int[][] graph,int v,List<Integer> temp,List<List<Integer>> ans)
    { 
        if(v==graph.length-1)
        {   ans.add(new ArrayList<Integer>(temp));
            return true;}
        for(int i=1;i<graph.length;i++){
            if(isSafe(graph,i,v,temp))
            {
                temp.add(i);
                solve(graph,i,temp,ans);
                temp.remove(temp.size()-1);
            }
        }
        return false;
    }
    
    private boolean isSafe(int[][] graph,int i,int v,List<Integer> temp){
        if(i==v || temp.contains(i)) return false;
        for(int j=0;j<graph[v].length;j++){
            if(graph[v][j]==i) return true;  
        }
        return false;
    }
    
}

//Solution 2(dfs)
class Solution {
    List<List<Integer>> ans;
    List<Integer> temp;
    int n;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans=new ArrayList<>();
        temp=new ArrayList<>();
        n=graph.length;
        temp.add(0);
        dfs(0,graph);
        return ans;
    }
    
    void dfs(int node,int[][] graph){
        if(node==n-1) ans.add(new ArrayList<>(temp));
        else{
            for(int i:graph[node]){
                temp.add(i);
                dfs(i,graph);
                temp.remove(temp.size()-1);
            }
        }
    }
}
