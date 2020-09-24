/* Problem:
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.  */

//My Solution(2 ms)
class Solution {
    public int reverse(int x) {
        if(x==0) return x;
        long d=0;int t=Math.abs(x);
        while(t>0){
            d=d*10+(long)(t%10);
            t/=10;
        }
        if(d>Math.pow(2,31)-1 || d<Math.pow(-2,31)) return 0;
        return (int)(d*(x/Math.abs(x)));
    }
}

//Solution(1 ms)
class Solution {
    public int reverse(int x) {
        boolean isNeg= false;
        if(x<0){
            isNeg = true;
            x=x*-1;
        }
        long n=0;
        while(x>0){
            int r = x%10;
            n = n*10+r;
            x=x/10;
        }
        
        if(n > Integer.MAX_VALUE){
            return 0;
        }else if(isNeg){
            n= n*-1; 
        }
        
            return (int)n;
        
    }
}
