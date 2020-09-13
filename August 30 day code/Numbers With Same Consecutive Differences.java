/* Problem:
Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.

Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.

You may return the answer in any order.

 

Example 1:

Input: n = 3, k = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
Example 2:

Input: n = 2, k = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
Example 3:

Input: n = 2, k = 0
Output: [11,22,33,44,55,66,77,88,99]
Example 4:

Input: n = 2, k = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
Example 5:

Input: n = 2, k = 2
Output: [13,20,24,31,35,42,46,53,57,64,68,75,79,86,97]
 

Constraints:

2 <= n <= 9
0 <= k <= 9  */

//My Solution(2 ms, 86% time, 70% time)

class Solution {
     List<Integer> res=new ArrayList<>();
    public int[] numsSameConsecDiff(int n, int k) {
        for(int i=1;i<10;i++){
           int t=0;
           dfs(k,n,i,t);
        }
           int[] ans=new int[res.size()];
        for(int i=0;i<res.size();i++)  ans[i]=res.get(i);
        return ans;
    }
    
    private void dfs(int k,int n,int i,int t){
        t=t*10+i;
        n--;
        if(n==0){ int flag=1;   
           String temp=Integer.toString(t);
           for(int z=1;z<temp.length();z++){
               if(Math.abs((int)(temp.charAt(z)-temp.charAt(z-1)))!=k) 
               {  flag=0;break;}
           }  if(flag==1) res.add(t); return;}  
    for(int j=0;j<10;j++){ if(Math.abs(t%10-j)==k) dfs(k,n,j,t);}
    }
        }
