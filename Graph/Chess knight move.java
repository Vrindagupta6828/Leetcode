/* Question:
Carol is learning chess and has difficulty with knight move. Her teacher gave her an practice. Take two random squares from chess board and try to take a knight from one square to the other with the least number of moves.

Help Carol with a program that evaluates the minimum number of moves a knight needs to travel from one square to another.

 

Input
First line contains an integer T denotes the number of test cases. The T following lines, each line contains start and final squares space separated. Chess board square is described by chess algebraic notation, i.e., a letter followed by a digit, letters from a to h represent columns and digits from 1 to 8 represents rows of chessboard.

 

Output
For each test case, output a single line containing the minimum number of moves a knight needs to travel from a square to another.

 

Example
Input:
2
a1 b1
g8 f6

Output:
3
1  */


//Solution:
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	static int[][] vis;
    static int[][] dist;
    static int[] dx= {-2,-1,1,2,2,1,-1,-2};
    static int[] dy= {1,2,2,1,-1,-2,-2,-1};
	static int endx,endy;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        while(t-->0) {
         vis=new int[8][8];
         dist=new int[8][8];
         String inp=sc.nextLine();
         int srcx=inp.charAt(1)-49;
         int srcy=inp.charAt(0)-97;
         endx=inp.charAt(4)-49;
         endy=inp.charAt(3)-97;
         
         /*    "OR"
         int srcx=inp.charAt(1)-'0'-1;
         int srcy=inp.charAt(0)-'a';
         endx=inp.charAt(4)-'0'-1;
         endy=inp.charAt(3)-'a';  */
        
        bfs(srcx,srcy);
        System.out.println(dist[endx][endy]);
        }
	}
	
	static void bfs(int srcx,int srcy) {
		Queue<int[]> q=new LinkedList<>();
		q.add(new int[]{srcx,srcy});
		dist[srcx][srcy]=0;
		vis[srcx][srcy]=1;
		boolean flag=false;
		
		while(!q.isEmpty()) {
			int[] curr=q.poll();
			int currx=curr[0];
			int curry=curr[1];
			
			for(int i=0;i<8;i++) {
				if(isValid(currx+dx[i],curry+dy[i]))
				{int newx=currx+dx[i];
				 int newy=curry+dy[i];
				 dist[newx][newy]=dist[currx][curry]+1;
				 vis[newx][newy]=1;
				 q.add(new int[]{newx,newy});
				 if(newx==endx && newy==endy) {flag=true;break;}
				}
			}
			if(flag) break;
		}
	}
	
	static boolean isValid(int x,int y) {
		if(x<0 || y<0 || x>7 || y>7) return false;
		
		if(vis[x][y]==1) return false;
		
		return true;
	}

}

