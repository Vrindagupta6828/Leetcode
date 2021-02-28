/* Question:
Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach’s conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d] 

If a < c OR a==c AND b < d.    */

//Solution

public class Solution {
    public ArrayList<Integer> primesum(int A) {
        
        ArrayList<Integer> primes = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=2;i<=A/2;i++){
            if(isPrime(i) && isPrime(A-i))
            {    ans.add(i);
                 ans.add(A-i);
                 break;
            }
        }
        
        return ans;
    }
    
    boolean isPrime(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0)
              return false;
        }
        return true;
    }
}
