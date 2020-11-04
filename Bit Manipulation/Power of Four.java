/* Question:
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true
Example 2:

Input: 5
Output: false
Follow up: Could you solve it without loops/recursion?  */

//Solution 1 (O(n) in worst case)
class Solution {
    public boolean isPowerOfFour(int num) {
    if ((num & num-1)==0){
        int pos=-1;
        while(num!=0){
            pos++;
            if((num&1)==1) break;
            num>>=1;
        }
        if(pos%2==0) return true;}
    return false;
    }   
}

//Solution 2(O(1))
class Solution {
    public boolean isPowerOfFour(int num) {
        if(num<=0) return false;
        int i = num & (num-1);
        int digit = (int)(Math.log(num)/Math.log(2));
        return i==0 && digit%2==0;
    }
}
