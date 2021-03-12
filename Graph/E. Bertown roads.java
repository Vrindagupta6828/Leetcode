/* Question:
Bertown has n junctions and m bidirectional roads. We know that one can get from any junction to any other one by the existing roads.

As there were more and more cars in the city, traffic jams started to pose real problems. To deal with them the government decided to make the traffic one-directional on all the roads, thus easing down the traffic. Your task is to determine whether there is a way to make the traffic one-directional so that there still is the possibility to get from any junction to any other one. If the answer is positive, you should also find one of the possible ways to orient the roads.

Input
The first line contains two space-separated integers n and m (2 ≤ n ≤ 105, n - 1 ≤ m ≤ 3·105) which represent the number of junctions and the roads in the town correspondingly. Then follow m lines, each containing two numbers which describe the roads in the city. Each road is determined by two integers ai and bi (1 ≤ ai, bi ≤ n, ai ≠ bi) — the numbers of junctions it connects.

It is guaranteed that one can get from any junction to any other one along the existing bidirectional roads. Each road connects different junctions, there is no more than one road between each pair of junctions.

Output
If there's no solution, print the single number 0. Otherwise, print m lines each containing two integers pi and qi — each road's orientation. That is the traffic flow will move along a one-directional road from junction pi to junction qi. You can print the roads in any order. If there are several solutions to that problem, print any of them.

Examples
input
6 8
1 2
2 3
1 3
4 5
4 6
5 6
2 4
3 5
output
1 2
2 3
3 1
4 5
5 6
6 4
4 2
3 5
input
6 7
1 2
2 3
1 3
4 5
4 6
5 6
2 4
output
0  */

//Solution:
import java.util.ArrayList;
import java.util.Scanner;

public class bertown_roads {

	static ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    static int[] vis=new int[100001];
    static int[] in=new int[100001];
    static int[] low=new int[100001];
    static int timer=0;
    static boolean hasBridge=false;
    static ArrayList<Pair<Integer,Integer>> edgeList=new ArrayList<>();
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    Scanner sc = new Scanner(System.in);
        
		    int n=sc.nextInt();
        int m=sc.nextInt();
        
        for(int i=0;i<=n;i++)
           adj.add(new ArrayList<Integer>());

        for(int i=1;i<=m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        dfs(1,-1);
        
        if(hasBridge)
        	 System.out.println("0");
        else {
        	for(Pair<Integer,Integer> p:edgeList) {
        		System.out.println(p.getKey()+" "+p.getValue());
        	}
        }
        
	}
	
	static void dfs(int node,int par) {
		vis[node]=1;
		in[node]=timer;
		low[node]=timer;
		timer++;
		for(int child:adj.get(node)) {
			if(child==par)
				continue;
			else if(vis[child]==1) {
				low[node]=Math.min(low[node], in[child]);
				if(in[child]<in[node])
					edgeList.add(new Pair(node,child));
			}
			else {
				dfs(child,node);
				if(low[child]>in[node]) {
					hasBridge=true;
					return;
				}
				low[node]=Math.min(low[node], low[child]);
				edgeList.add(new Pair(node,child));
			}
		}
	}

}
