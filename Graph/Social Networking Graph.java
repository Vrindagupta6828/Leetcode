/* Problem
In a social networking site, people are connected with other people. The whole system appears as a giant connected graph. In this question, you are required to answer the total number of people connected at t nodes away from each other (t distance connectivity). For example: Two persons directly connected are at 1 distance connectivity. While the two persons having a common contact without having direct connectivity, are at 2 distance connectivity.

First line of input line contains, two integers n and e, where n is the nodes and e are the edges. Next e line will contain two integers u and v meaning that node u and node v are connected to each other in undirected fashion. Next line contains single integer, m, which is number of queries. Next m lines, each have two inputs, one as source node and other as a required t distance connectivity which should be used to process query.

 

Note: The index of nodes will be 0-based. The example and the test case shown is of 1-based index. For submitting the solution, use 0-based indexing.

Sample Input
9 10
1 2
2 3
1 7
2 4
3 4
4 7
7 8
9 7
7 6
5 6
3
4 2
5 3
2 1
Sample Output
4
4
3
Time Limit: 5
Memory Limit: 256
Source Limit:
Explanation
After creating the graph, there was 3 queries,

Source node: 4, and we have to find out total number of nodes at a distance of 2 from node 4.
1(4->2->1), 8(4->7->8), 9(4->7->9), 6(4->7->6) = 4

Similarly as above
Source node: 2, and we have to find out total number of nodes at a distance of 1 from node 2.
1(2->1), 4(2->4), 3(2->3) = 3   */

//Solution
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;

public class Feasible_relation {

	static ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    static int[] vis=new int[100001];
    static int[] level=new int[100001];
    static int[] dist=new int[100001];
	
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	    Scanner sc = new Scanner(System.in);
        
			int n=sc.nextInt();
			int m=sc.nextInt();

			for(int i=0;i<=n;i++) adj.add(new ArrayList<Integer>());
			
			for(int i=1;i<=m;i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				adj.get(a).add(b);
				adj.get(b).add(a);
			}
			
			int q=sc.nextInt();
			
			while(q-->0) {
				int src=sc.nextInt();
				int d=sc.nextInt();
				
			    for(int i=1;i<=n;i++) {
				 vis[i]=0;
				 level[i]=0;
			    }
			    
			    bfs(src);
			    
			    System.out.println(level[d]);
			}

		}
    
    static void bfs(int node) {
    	Queue<Integer> q=new LinkedList<>();
    	q.add(node);
    	dist[node]=0;
    	vis[node]=1;
    	
    	while(!q.isEmpty()) {
    		int curr=q.poll();
    		for(int child:adj.get(curr)) {
    			if(vis[child]==0) {
    				q.add(child);
    				vis[child]=1;
    				dist[child]=dist[curr]+1;
    				level[dist[child]]++;
    			}
    		}
    	}
    }
}


