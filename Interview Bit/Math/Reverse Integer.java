/* Reverse digits of an integer.

Example1:

x = 123,

return 321
Example2:

x = -123,

return -321

Return 0 if the result overflows and does not fit in a 32 bit signed integer   */

//Solution
public class Solution {
    public int reverse(int A) {
        
        boolean negative=A<0?true:false;
        A=Math.abs(A);
        long d=0;
        while(A>0){
            d=d*10+A%10;
            A/=10;
        }
        
        if(negative) d=d*-1;
        
        if(d<-2147483648 || d>2147483647) return 0;
        return (int)d;
    }
}

//2
public class Solution {
    public int reverse(int A) {
        //if(A < Integer.MIN_VALUE || A > Integer.MAX_VALUE) return 0;
        boolean neg = A < 0;
        A = Math.abs(A);
        long ret = 0;
        while(A != 0){
            ret = ret*10 + A%10;
            A = A/10;
        }
        if(ret > Integer.MAX_VALUE) return 0;
        return neg ? -(int)ret : (int)ret;
    }
}
