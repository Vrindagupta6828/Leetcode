/* Question:
Vice City is built over a group of islands, with bridges connecting them. As anyone in Vice City knows, the biggest fear of vice-citiers is that some day the islands will submerge. The big problem with this is that once the islands submerge, some of the other islands could get disconnected. You have been hired by the mayor of Vice city to tell him how many islands, when submerged, will disconnect parts of Vice City. You should know that initially all the islands of the city are connected.

Input
The input will consist of a series of test cases. Each test case will start with the number N (1 ≤ N ≤ 10^4) of islands, and the number M of bridges (1 ≤ M ≤ 10^5). Following there will be M lines each describing a bridge. Each of these M lines will contain two integers Ui, Vi (1 ≤ Ui,Vi ≤ N), indicating that there is a bridge connecting islands Ui and Vi. The input ends with a case where N = M = 0.

Output
For each case on the input you must print a line indicating the number of islands that, when submerged, will disconnect parts of the city.

Example
Input:
3 3
1 2
2 3
1 3
6 8
1 3
6 1
6 3
4 1
6 4
5 2
3 2
3 5
0 0


Output:
0
1   */

//Solution
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class bertown_roads {

	static ArrayList<ArrayList<Integer>> adj;
    static int[] vis=new int[10001];
    static int[] in=new int[10001];
    static int[] low=new int[10001];
    static int timer=0;
    static HashSet<Integer> ans;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        
		int n=sc.nextInt();
        int m=sc.nextInt();
        
        while(n>0 && m>0) {
        	
        	timer=0;
        	adj=new ArrayList<>();
        	ans=new HashSet<>();
	        for(int i=0;i<=n;i++)
	           { adj.add(new ArrayList<Integer>());
	             vis[i]=0;
	           }
	
	        for(int i=1;i<=m;i++){
	            int a=sc.nextInt();
	            int b=sc.nextInt();
	            adj.get(a).add(b);
	            adj.get(b).add(a);
	        }
	        
	        for(int i=1;i<=n;i++) {
	        	if(vis[i]==0)
	            dfs(1,-1);
	        }
	        
	        System.out.println(ans.size());
	        
	        n=sc.nextInt();
	        m=sc.nextInt();
	        
	    }
	        
	}
	
	static void dfs(int node,int par) {
		vis[node]=1;
		in[node]=timer;
		low[node]=timer;
		timer++;
		int children=0;
		for(int child:adj.get(node)) {
			if(child==par)
				continue;
			else if(vis[child]==1)
				low[node]=Math.min(low[node], in[child]);
			else {
				dfs(child,node);
				low[node]=Math.min(low[node], low[child]);
				if(low[child]>=in[node] && par!=-1)
					ans.add(node);
				++children;
			}
		}
		if(par==-1 && children>1)
			ans.add(node);
	}

}
