/* Question:
Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False   */

//Solution 1
public class Solution {
    public int isPalindrome(int A) {
        int d=0,t=A;
        while(A>0){
            d=(d*10)+(A%10);
            A/=10;
        }
        
        return (t==d)?1:0; 
    }
}
