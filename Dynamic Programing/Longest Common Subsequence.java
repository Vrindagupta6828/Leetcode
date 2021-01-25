/* Question:
Given two sequences, find the length of longest subsequence present in both of them. Both the strings are of uppercase.

Example 1:

Input:
A = 6, B = 6
str1 = ABCDGH
str2 = AEDFHR
Output: 3
Explanation: LCS for input Sequences
“ABCDGH” and “AEDFHR” is “ADH” of
length 3.
Example 1:

Input:
A = 3, B = 2
str1 = ABC
str2 = AC
Output: 2
Explanation: LCS of "ABC" and "AC" is
"AC" of length 2.
Your Task:
Complete the function lcs() which takes the length of two strings respectively and two strings as input parameters and returns the length of the longest subsequence present in both of them.

Expected Time Complexity : O(|str1|*|str2|)
Expected Auxiliary Space: O(|str1|*|str2|)

Constraints:
1<=size(str1),size(str2)<=100  */

//Solution(o(p*q) time and space)
class LCS{
    
    // function to find LCS
    static int[][] t;
    static int lcs(int p, int q, String s1, String s2){
        // your code here
        t=new int[p+1][q+1];
        for(int i=0;i<=p;i++){
            for(int j=0;j<=q;j++){
                if(i==0||j==0)
                   t[i][j]=0;
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                  t[i][j]= 1+t[i-1][j-1];
                else
                  t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
            }
        }
        return t[p][q];
    }
}
