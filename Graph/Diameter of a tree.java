import java.util.ArrayList;
import java.util.Scanner;

public class diameter {

	static ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    static int[] vis=new int[10001];
    static int maxD,maxNode;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        
		int n=sc.nextInt();
        
        for(int i=0;i<=n;i++)
           adj.add(new ArrayList<Integer>());

        for(int i=1;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        maxD=-1;
        dfs(1,0);
        
        //Arrays.fill(vis,0);
        for(int i=0;i<=n;i++) vis[i]=0;
        maxD=-1;
        dfs(maxNode,0);
        
        System.out.println(maxD);
        sc.close();

	}
	
	static void dfs(int node,int d) {
		vis[node]=1;
		if(d>maxD) {maxD=d;maxNode=node;}
		
		for(int child:adj.get(node)) {
			if(vis[child]==0) {
				dfs(child,d+1);
			}
		}
	}

}
