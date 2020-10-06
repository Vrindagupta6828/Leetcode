/* Problem:
Every non-negative integer N has a binary representation.  For example, 5 can be represented as "101" in binary, 11 as "1011" in binary, and so on.  Note that except for N = 0, there are no leading zeroes in any binary representation.

The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1.  For example, the complement of "101" in binary is "010" in binary.

For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.

 

Example 1:

Input: 5
Output: 2
Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
Example 2:

Input: 7
Output: 0
Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
Example 3:

Input: 10
Output: 5
Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
 

Note:

0 <= N < 10^9   */

//Solution
class Solution {
    public int bitwiseComplement(int N) {
        int c=0;int t=N;int a=0;
        if(N==1 || N==0) return (1-N);
        while(t>0){
            c++;
            t/=2;
        }
        int[] binaryNum=new int[c];
        for(int i=0;i<c;i++)  binaryNum[i]=1;
        long num=0;int p=0;
        for(int i=c-1;i>=0;i--){
            num+=(binaryNum[i]*Math.pow(2,p));
            p++;
        }
        return (int)(num-N);
    }
}

