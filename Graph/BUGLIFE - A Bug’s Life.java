/* Question:(Bipartile graph)
Professor Hopper is researching the sexual behavior of a rare species of bugs. He assumes that they feature two different genders and that they only interact with bugs of the opposite gender. In his experiment, individual bugs and their interactions were easy to identify, because numbers were printed on their backs.

Given a list of bug interactions, decide whether the experiment supports his assumption of two genders with no homosexual bugs or if it contains some bug interactions that falsify it.

Input
The first line of the input contains the number of scenarios. Each scenario starts with one line giving the number of bugs (at least one, and up to 2000) and the number of interactions (up to 1000000) separated by a single space. In the following lines, each interaction is given in the form of two distinct bug numbers separated by a single space. Bugs are numbered consecutively starting from one.

Output
The output for every scenario is a line containing “Scenario #i:”, where i is the number of the scenario starting at 1, followed by one line saying either “No suspicious bugs found!” if the experiment is consistent with his assumption about the bugs’ sexual behavior, or “Suspicious bugs found!” if Professor Hopper’s assumption is definitely wrong.

Example
Input:
2
3 3
1 2
2 3
1 3
4 2
1 2
3 4

Output:
Scenario #1:
Suspicious bugs found!
Scenario #2:
No suspicious bugs found!  */

//Solution
import java.util.ArrayList;
import java.util.Scanner;

public class bugs_bipartile {

	static ArrayList<ArrayList<Integer>> adj;
    static int[] vis;
    static int[] col;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int p=1;p<=t;p++) {
        adj=new ArrayList<>();
        vis=new int[2001];
        col=new int[2001];
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
        
        int flag=0;
        
        System.out.println("Scenario #"+p+":");
        
        for(int i=1;i<=n;i++){
            if(vis[i]==0){
                if(!dfs(i,1))
                {	System.out.println("Suspicious bugs found!");
                    flag=1;
                    break;}
            }
        }
        if(flag==0) System.out.println("No suspicious bugs found!"); 
        }
	}
	
	static boolean dfs(int v,int c) {
		vis[v]=1;
		col[v]=c;
		
		for(int child:adj.get(v)) {
			if(vis[child]==0) {
				if(!dfs(child,c^1))
					return false;
					 
			}
			else if(col[v]==col[child])
				  return false;
		}
		return true;
	}

}
