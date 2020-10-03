/* Problem:
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), for N > 1.
Given N, calculate F(N).

 

Example 1:

Input: 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 

Note:

0 ≤ N ≤ 30.  */

//Solution(o(n) time and space)

class Solution {
    public int fib(int N) {
        List<Integer> f=new ArrayList<>();
        f.add(0);f.add(1);int i=2;
        while(i<=N){
            f.add(f.get(i-1)+f.get(i-2));
            i++;
        }
        return f.get(N);
    }
}

//Solution 2(o(n) time and o(1) space)
class Solution {
    public int fib(int N) {
        if(N==0) return 0;
        if(N==1) return 1;
        int a=0;int b=1;int i=2;
        while(i<=N){
            int temp=a+b;
            a=b;
            b=temp;
            i++;
        }
        return b;
    }
}

//Solution 3(o(1) time and space)
class Solution {
    public int fib(int N) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int)Math.round(Math.pow(goldenRatio, N)/ Math.sqrt(5));
    }
}
