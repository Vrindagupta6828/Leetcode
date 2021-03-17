/* Question:
Problem
Dilku was thinking about the first time he met his girl... It was indeed a walk to remember. The romantic weather and her silly talks. He was completely mesmarized. Those were the days!..

Today is his girl's birthday and he wants to make it special for her. He wants to again take her on a "special walk" that they would remember for the lifetime.

The city in which Dilku lives is represented as an unweighted directed graph with N nodes and M edges. A "special walk" in the graph starting at node u is a simple path that begins and ends at the same node u.

Formally, A special walk is path u , a1 , a2 , a3 ,..., ai ,.... , u where ai are distinct and not equal to u for all i.

Now since Dilku is really nervous about taking his girl out, he needs your help. For every node in the given graph, tell whether it is possible for Dilku to take his girl on a "special walk" starting at that node.

Input:

First line of a two space separated integers denoting N and M, the number of nodes and number of directed edges in the corresponding graph.
Following M lines contain two space separated integers u v denoting a directed edge in the graph from vertex numbered u to vertex numbered v.

Output:

Print N space separated integers, where ith integer can be either 1 or 0 depicting whether it is possible to go on a special walk starting at node i or not.

Constraints:

1 ≤ N ≤ 105
1 ≤ M ≤ 2 · 105
1 ≤ u, v ≤ N
Sample Input
5 5
1 2 
2 3 
3 4 
4 5
4 2
Sample Output
0 1 1 1 0    */

//Solution:
import java.util.*;
class TestClass {
    static int[] vis=new int[1000001];
	static ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
	static ArrayList<ArrayList<Integer>> tr=new ArrayList<>();
	static ArrayList<Integer> order=new ArrayList<>();
	static ArrayList<Integer> scc=new ArrayList<>();
    static int[] ans=new int[100001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int m=sc.nextInt();

        for(int i=0;i<=n;i++) {
        	ar.add(new ArrayList<>());
        	tr.add(new ArrayList<>());
        }
        	
        for(int i=1;i<=m;i++) {
        	int a=sc.nextInt();
        	int b=sc.nextInt();
        	ar.get(a).add(b);
        	tr.get(b).add(a);
    	}
        	
    	for(int i=1;i<=n;i++) {
    		if(vis[i]==0)
    			dfs(i);
    	}
        	
        for(int i=1;i<=n;i++)
        	vis[i]=0;
        	
        for(int i=1;i<=n;i++) {
        	if(vis[order.get(n-i)]==0)
        	{ scc.clear();
     		  dfs1(order.get(n-i));
        	  updateanswer();
        		 
        	}
        }
        	
        for(int i=1;i<=n;i++)
        System.out.print(ans[i]+" ");
        
	}

    static void updateanswer(){
        if(scc.size()<=1) return;
        for(int node:scc) ans[node]=1;
    }
	
	static void dfs(int node) {
		vis[node]=1;
		for(int child:ar.get(node)) {
			if(vis[child]==0)
				dfs(child);
		}
		order.add(node);
	}
	
	static void dfs1(int node) {
		vis[node]=1;
		for(int child:tr.get(node)) {
			if(vis[child]==0)
				dfs1(child);
		}
		scc.add(node);
	}
	

}
