/* Question:
Given a string str, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome. Determine the fewest cuts needed for palindrome partitioning of given string.


Example 1:

Input: str = "ababbbabbababa"
Output: 3
Explaination: After 3 partitioning substrings 
are "a", "babbbab", "b", "ababa".

Example 2:

Input: str = "aaabba"
Output: 1
Explaination: The substrings after 1
partitioning are "aa" and "abba".

Your Task:
You do not need to read input or print anything, Your task is to complete the function palindromicPartition() which takes the string str as input parameter and returns minimum number of partitions required.


Expected Time Complexity: O(n*n) [n is the length of the string str]
Expected Auxiliary Space: O(n*n)


Constraints:
1 ≤ length of str ≤ 500 */

//Solution 1(recursion)
class Solution{
    static int palindromicPartition(String str)
    {
        // code here
        int n=str.length();
        return pp(str,0,n-1);
    }
    
    static int pp(String str,int i,int j){
        if(i>=j) return 0;
        if(Palindrome(str,i,j))  return 0;
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp_ans=1+pp(str,i,k)+pp(str,k+1,j);
            min=Math.min(min,temp_ans);
        }
        return min;
    } 
    
    static boolean Palindrome(String s,int i,int j){
        while(j>i){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }
}

//Solution 2(memorize)(o(n^3) time and o(n^2) space)
class Solution{
    static int[][] t;
    static int palindromicPartition(String str)
    {
        // code here
        int n=str.length();
        t=new int[n+1][n+1];
        for(int[] r:t)
           Arrays.fill(r,-1);
        return pp(str,0,n-1);
    }
    
    static int pp(String str,int i,int j){
        if(i>=j) return 0;
        if(t[i][j]!=-1)  return t[i][j];
        if(Palindrome(str,i,j))  
        {     t[i][j]=0;
              return 0;
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int left,right;
            if(t[i][k]!=-1)
              left=t[i][k];
            else{
                left=pp(str,i,k);
                t[i][k]=left;
            }
            if(t[k+1][j]!=-1)
              right=t[k+1][j];
            else{
                right=pp(str,k+1,j);
                t[k+1][j]=right;
            }
            
            int temp_ans=1+left+right;
            min=Math.min(min,temp_ans);
        }
        t[i][j]=min;
        return min;
    } 
    
    static boolean Palindrome(String s,int i,int j){
        while(j>i){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }
}
