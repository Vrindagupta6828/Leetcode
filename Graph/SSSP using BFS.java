/* Question: Monk and the Islands
Problem
Monk visits the land of Islands. There are a total of N islands numbered from 1 to N. Some pairs of islands are connected to each other by Bidirectional bridges running over water.
Monk hates to cross these bridges as they require a lot of efforts. He is standing at Island #1 and wants to reach the Island #N. Find the minimum the number of bridges that he shall have to cross, if he takes the optimal route.

Input:
First line contains T. T testcases follow.
First line of each test case contains two space-separated integers N, M.
Each of the next M lines contains two space-separated integers X and Y , denoting that there is a bridge between Island X and Island Y.

Output:
Print the answer to each test case in a new line.

Constraints:
1 ≤ T ≤ 10
1 ≤ N ≤ 104
1 ≤ M ≤ 105
1 ≤ X, Y ≤ N

Sample Input
2
3 2
1 2
2 3
4 4
1 2
2 3
3 4
4 2
Sample Output
2
2   */

//Solution
import java.util.*;
class TestClass {
    
    static ArrayList<ArrayList<Integer>> adj;
    static int[] vis;
    static int[] dist;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        
		int t=sc.nextInt();
		while(t-->0) {
        int n=sc.nextInt();
        int m=sc.nextInt();
        
        adj=new ArrayList<>();
        vis=new int[n+1];
        dist=new int[n+1];
        
        for(int i=0;i<=n;i++)
           adj.add(new ArrayList<Integer>());

        for(int i=1;i<=m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        bfs(1);
        
        System.out.println(dist[n]);
	}
	}
	
	static void bfs(int s) {
		vis[s]=1;
		Queue<Integer> q=new LinkedList<>();
		q.add(s);
		
		while(!q.isEmpty()) {
			int temp=q.poll();
			
			for(int child:adj.get(temp)) {
				if(vis[child]==0) {
					vis[child]=1;
					dist[child]=dist[temp]+1;
					q.add(child);
				}
			}
			
		}
	}
}
