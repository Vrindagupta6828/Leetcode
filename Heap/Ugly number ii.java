/* Question:
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.  */

//Solution 1(Using heap o(1) time and space)
class Solution {
    public static Ugly obj=new Ugly();
    public int nthUglyNumber(int n) {
          return obj.u[n-1];        
    }
}

class Ugly{
    int[] u=new int[1690];
    Ugly(){
        HashSet<Long> seen=new HashSet<>();
        PriorityQueue<Long> max=new PriorityQueue<>();
        seen.add(1L);
        max.add(1L);
        
        long currUgly,newUgly;
        int[] primes=new int[]{2,3,5};
        for(int i=0;i<1690;i++){
            currUgly=max.poll();
            u[i]=(int)currUgly;
            for(int j:primes){
                newUgly=j*currUgly;
                if(!seen.contains(newUgly)){
                    seen.add(newUgly);
                    max.add(newUgly);
                }
            }
        }
        
    }
}

//Solution 2(using dp o(1) time and space)
class Solution {
    public static Ugly obj=new Ugly();
    public int nthUglyNumber(int n) {
          return obj.u[n-1];        
    }
}

class Ugly{
    int[] u=new int[1690];
    Ugly(){
       u[0]=1;
       int i2=0,i3=0,i5=0;
        for(int i=1;i<1690;i++){
            u[i]=Math.min(Math.min(u[i2]*2,u[i3]*3),u[i5]*5);
            if(u[i]==u[i2]*2) ++i2; 
            if(u[i]==u[i3]*3) ++i3; 
            if(u[i]==u[i5]*5) ++i5; 
        }
        }
        
    }
