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

//Solution
class Solution {
    public int countPrimes(int n) {
        if(n==1 || n==0) return 0;
        int count=0;
        
        int[] arr=new int[n];
        
        for(int i=2;i*i<n;i++){
            if(arr[i]==0){
              for(int j=i*i;j<n;j+=i){
                arr[j]=1;    
              }
            }
        }
        
        for(int i=2;i<n;i++){
            if(arr[i]==0) count++;
        }
        
        return count;
    }
}
