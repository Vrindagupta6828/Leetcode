/* Question:
Chef cooks nice receipes in the cafeteria of his company. The cafe contains N boxes with food enumerated from 1 to N and are placed in a circle in clocwise order (boxes 1 and N are adjacent). Each box has unlimited amount of food with a tastyness level of Ai. Chef invented a definition of a magic box!

Chef picks a box i and stays in front of it.
Now Chef eats food from box i and skips next Ai boxes.
Now Chef is staying at some other (probably even the same!) box and repeats.
Box i is a magic box if at some point of such game started from box i, Chef will find himself staying in front of it again.
When Chef came home, Chef's dog Tommy asked him about how many magic boxes were in the cafe? Help Chef to in finding that!

Input
The first line of the input contains an integer T denoting the number of test cases. The description of T test cases follows.

The first line of each test case contains a single integer N denoting the number of boxes.

The second line contains N space-separated integers A1, A2, ..., AN denoting the tastyness levels of each box.

Output
For each test case, output a single line containing number of magical boxes.

Constraints
1 ≤ sum of all N over all the test cases in a single test file ≤ 106
0 ≤ Ai ≤ 109
Subtasks
Subtask #1 (30 points): 1 ≤ sum of all N over all the test cases ≤ 104; 1 ≤ N ≤ 1000
Subtask #2 (70 points): 1 ≤ sum of all N over all the test cases ≤ 106; 1 ≤ N ≤ 105
Example
Input:
3
4
1 1 1 1
4
3 0 0 0
4
0 0 0 2
Output:
4
1
2
Explanation
Example case 1.

Here are Chef's paths if he starting from each the box:
1->3->1
2->4->2
3->1->3
4->2->4
As you see, all 4 boxes are magical.
Example case 2.

Here are Chef's paths if he starts from each box appropriately:
1->1
2->3->4->1->1
3->4->1->1
4->1->1
AS you see, only box 1 is magical.   */

//Solution:
import java.util.*;

public class scc {
    
	static int[] vis=new int[1000001];
	static int[] val=new int[1000001];
	static ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
	static ArrayList<ArrayList<Integer>> tr=new ArrayList<>();
	static ArrayList<Integer> order=new ArrayList<>();
	static ArrayList<Integer> scc=new ArrayList<>();	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        
        int t=sc.nextInt();
        while(t-->0) {
        	int n=sc.nextInt();
        	ar.clear();
        	tr.clear();
        	int res=0;
            
            for(int i=0;i<n;i++) {
            	ar.add(new ArrayList<>());
            	tr.add(new ArrayList<>());
            }
        	
            order.clear();
            
        	for(int i=0;i<n;i++) {
        		val[i]=sc.nextInt();
        	    vis[i]=0;
        	}
        	
        	for(int i=0;i<n;i++) {
        		int a=i;
        		int b=(i+val[i]+1)%n;
        		ar.get(a).add(b);
        		tr.get(b).add(a);
        	}
        	
        	for(int i=0;i<n;i++) {
        		if(vis[i]==0)
        			dfs(i);
        	}
        	
        	for(int i=0;i<n;i++)
        		vis[i]=0;
        	
        	for(int i=0;i<n;i++) {
        		if(vis[order.get(n-i-1)]==0)
        		{ scc.clear();
        		 dfs1(order.get(n-i-1));
        		 
        		 if(scc.size()==1 && (scc.get(0)!= ar.get(scc.get(0)).get(0))) continue;
        		 
        		 res+=scc.size();
        		 
        		}
        	}
        	
        	System.out.println(res);
        }
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
