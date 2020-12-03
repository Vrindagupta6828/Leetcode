/* Question:
Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.
 

Now given N, how many beautiful arrangements can you construct?

Example 1:

Input: 2
Output: 2
Explanation: 

The first beautiful arrangement is [1, 2]:

Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second beautiful arrangement is [2, 1]:

Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 

Note:

N is a positive integer and will not exceed 15.  */

// Solution:(Backtracking)
class Solution {
    int count;
    public int countArrangement(int N) {
        count=0;
        ArrayList<Integer> temp=new ArrayList<>();
        solve(0,temp,N);
            return count;
    }
    
    private boolean solve(int pos,ArrayList<Integer> temp,int N){
        if(pos==N){
            count++;
            return true;}
        for(int i=1;i<=N;i++){
            if(isSafe(i,temp,pos)){
                temp.add(i);
                solve(pos+1,temp,N);
                temp.remove(temp.size()-1);
            }
        }
        return false;
    }
    
    private boolean isSafe(int i,ArrayList<Integer> temp,int pos){
        if(temp.contains(i)) return false;
        if((pos+1)%i==0 || i%(pos+1)==0) return true;
        return false;
    }
    }
    
    //Their Solution(o(k) time and o(n) space k refrs to valid permutations)
    public class Solution {
    int count = 0;
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        calculate(N, 1, visited);
        return count;
    }
    public void calculate(int N, int pos, boolean[] visited) {
        if (pos > N)
            count++;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                calculate(N, pos + 1, visited);
                visited[i] = false;
            }
        }
    }
}
