/* Question:
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as sqrt.

 

Example 1:

Input: num = 16
Output: true
Example 2:

Input: num = 14
Output: false
 

Constraints:

1 <= num <= 2^31 - 1  */

//Solution(O(logn))
class Solution {
    public boolean isPerfectSquare(int num) {
        long n=(long)num;
        long low=0,high=n;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(mid*mid==n)
                return true;
            else if(mid*mid<n)
                low=mid+1;
            else
                high=mid-1;
        }
        return false;
    }
}
