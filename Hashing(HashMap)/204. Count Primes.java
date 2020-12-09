/* Question:
Count the number of prime numbers less than a non-negative number, n.

 

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0
 

Constraints:

0 <= n <= 5 * 106  */

//Solution(sieve of eratosthenes)
class Solution {
    public int countPrimes(int n) 
    {
        if(n==0 || n==1)
        {
            return 0;
        }
        boolean[] prime=new boolean[n];
        
        for(int i=0;i<n;i++)
            prime[i]=true;
        
        for(int p=2;p*p<n;p++){
            if(prime[p]==true)
            { for(int i=p*p;i<n;i+=p)
               prime[i]=false;
            }
        }
        
        int count=0;
        for(int i=2;i<n;i++){
            if(prime[i]==true)
                count++;
        }
        return count;
    }
}

Time complexity : O(n*log(log(n)))
