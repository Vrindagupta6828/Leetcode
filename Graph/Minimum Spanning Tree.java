/* Question:
Given a weighted undirected graph. Find the sum of weights of edges of a Minimum Spanning Tree.

Input:
Given 2 integers N and M. N represents the number of vertices in the graph. M represents the number of edges between any 2 vertices.
Then M lines follow, each line has 3 space separated integers  , ,  where  and  represents an edge from a vertex  to a vertex  and  respresents the weight of that edge.

Output:
Print the summation of edges weights in the MST.

Constraints:




Sample Input
4 5
1 2 7
1 4 6
4 2 9
4 3 8
2 3 6
Sample Output
19
  */

//Solution
import java.util.*;
class TestClass {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
	public static class edge implements Comparable<edge>{
		int a;
		int b;
		int w;
		edge(int a,int b,int w){
			this.a=a;
			this.b=b;
			this.w=w;
		}
		
	    public int compareTo(edge e) {
	        /* For Ascending order*/
	        return this.w-e.w;}
	}
	
	static ArrayList<edge> arr=new ArrayList<>();
    static int[] par=new int[10001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        
        for(int i=1;i<=n;i++)  par[i]=-1;
        
        for(int i=0;i<m;i++) {
        	int a=sc.nextInt();
        	int b=sc.nextInt();
        	int w=sc.nextInt();
        	edge e=new edge(a,b,w);
        	arr.add(e);
        }
        
        Collections.sort(arr);
        
        int sum=0;
        
        for(int i=0;i<m;i++) {
        	int a= find(arr.get(i).a);
        	int b=find(arr.get(i).b);
        	if(a!=b) {
        		sum+=arr.get(i).w;
        		merge(a,b);
        	}
        }
        
        System.out.println(sum);
	}
	
	static int find(int a) {
		if(par[a]<0) return a;
		
		par[a]=find(par[a]);
		return par[a];
	}
	
	static void merge(int a ,int b) {
		par[a]=b;
	}

}
