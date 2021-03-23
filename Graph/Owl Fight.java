/* Question:
Problem
Owl Arena is hosting a fight competition and many owls decided to take part in it.

Strength of an owl is the number associated with that owl.

Rules of the competition are:
An owl wins if its strength is greater than that of another.
An owl can ask his friend to fight that match for him.
Note : If A and B are friends, and B and C are friends, then A and C are also friends.

Input:
First line contains the number of owls participating N and the number of connections M.
M lines follow.
Each line contains two integers u and v denoting that they are friends.
Next line contains Q, the number of queries.
Q lines follow.
Each line contains two integers u and v. You need to tell who wins.
Output:
In each query, output the number of the owl that will win the match. If the owls(u and v) are in the same friend circle, output .

Constraints:
1  N,M,Q  5
u,v  N
Problem Setter - Harsh Jain

Sample Input
7 3
1 2
3 4
1 7
4
1 2
5 6
3 7
1 5
Sample Output
TIE
6
7
1
Time Limit: 1
Memory Limit: 256
Source Limit:
Explanation
1,2 and 7 are friends. 3 and 4 are friends. 5,6 and 7 have no friends. now,
First query: 1 and 2 : since both belong to the same friend circle, answer is a TIE.
Second: 5 and 6: since there is no friend of 5 and no friend of 6 and 6 has higher strength. 6 will win.
Third: 3 and 7: 3 has a friend 4 who has more strength than 3 and 7 has no friends whose strength is greater than his. so 4 vs 7. 7 will win.
Fourth: 1 and 5: 1 has a friend 7 who has more strength than 1 and 5 has no friends. so 5 vs 7. 7 will win. And since the fight was b/w 1 and 5. 1 wins the fight.  */

//Solution:
import java.util.*;
class TestClass {
    static int[] parent;
    public static void main(String args[] ) throws Exception {
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
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        parent=new int[n+1];
        for(int i=1;i<=n;i++)
           parent[i]=-i;
           
        while(m-->0){
            int u=sc.nextInt();
            int v=sc.nextInt();
            u=find(u);v=find(v);
            if(u!=v) union(u,v);
        }
        int q=sc.nextInt();
        while(q-->0){
            int u=sc.nextInt();
            int v=sc.nextInt();
            int find_u=find(u),find_v=find(v);
            
            if(find_u==find_v) 
                 System.out.println("TIE");
            else{
                if(parent[find_u]>parent[find_v])
                   System.out.println(v);
                else
                   System.out.println(u);
            }
        }

    }

    private static int find(int a){
        if(parent[a]<0)
            return a;
        else{
            parent[a]=find(parent[a]);
            return parent[a];
        }
    }

    private static void union(int a,int b){
        parent[a]=Math.min(parent[a],parent[b]);
        parent[b]=a;
    }
}
