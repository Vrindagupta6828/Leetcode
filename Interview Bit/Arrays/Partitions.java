/* Question:
Problem Description

You are given a 1D integer array B containing A integers.

Count the number of ways to split all the elements of the array into 3 contiguous parts so that the sum of elements in each part is the same.

Such that : sum(B[1],..B[i]) = sum(B[i+1],...B[j]) = sum(B[j+1],...B[n])



Problem Constraints
1 <= A <= 105

-109 <= B[i] <= 109



Input Format
First argument is an integer A.

Second argument is an 1D integer array B of size A.



Output Format
Return a single integer denoting the number of ways to split the array B into three parts with the same sum.



Example Input
Input 1:

 A = 5
 B = [1, 2, 3, 0, 3]
Input 2:

 A = 4
 B = [0, 1, -1, 0]


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 There are no 2 ways to make partitions -
 1. (1,2)+(3)+(0,3).
 2. (1,2)+(3,0)+(3).
Explanation 2:

 There is only 1 way to make partition -
 1. (0)+(-1,1)+(0).    */

//Solution
public class Solution {
    public int solve(int A, ArrayList<Integer> B) {
        int sum=0;
        
        //Calculating sum
        for(int i=0;i<A;i++)
            sum+=B.get(i);
        
        //if sum%3 not 0 then we cannot divide it into 3 parts
        if(sum%3!=0) return 0;
        sum=sum/3;
        
        ArrayList<Integer> suffix=new ArrayList<>();
        ArrayList<Integer> prefix=new ArrayList<>();
        
        int x=0;
        
        //calculating that prefix starting from 1 can be till which length possible
        //adding those indices till which possible in prefix array
        for(int i=0;i<A;i++)
        { x+=B.get(i);
          if(x==sum) prefix.add(i);
        }
        
        x=0;
        //calculating that suffix starting from n can be till which length possible
        //adding those indices till which possible in suffix array
        for(int i=A-1;i>=0;i--){
            x+=B.get(i);
            if(x==sum) suffix.add(i);
        }
        
        int count=0;
        //from prefix index to suffix index calculating sum if middle sum is also 
        //equal to sum/3 then increment count
        for(int i:prefix){
            for(int j:suffix){
                x=0;int n=0;
                for(int p=i+1;p<j;p++){
                    x+=B.get(p);
                    n=1;
                }
                if(x==sum && n==1)  count++;
            }
        }
        
        return count;
    }
}
