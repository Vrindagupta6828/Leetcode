/* Problem:
Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.

 

Example 1:

Input: [1,2,3,4]
Output: "23:41"
Example 2:

Input: [5,5,5,5]
Output: ""

Note:

A.length == 4
0 <= A[i] <= 9 */

//Solution

/*1. Keep a initial max value as 0000
2. Generate all possible permuation that are possible.
3. check function is used to check wheather the time lies between the range 00:00 and 23:59.
4. if length of the generated string is 4, then compare with max value we had.
5. return the max value string in required format.*/

class Solution {
boolean[] vis;
String max;
boolean isPossible=false;
public boolean check(String ans) {
char[] r = ans.toCharArray();
if(((r[0]-'0')<2 && (r[1]-'0')<=9 || (r[0]-'0')==2 && (r[1]-'0')<=3)&& (r[2]-'0')<=5 && (r[3]-'0')<=9)
return true;
return false;
}
public void dfs(int s, int[] A, String ans) {
if(ans.length()==4 && check(ans)) {
int num1 = Integer.parseInt(ans), num2 = Integer.parseInt(max);
isPossible=true;
if(num1 > num2) max = ans;
}else {
vis[s]=true;
for(int i=0; i<4; i++)
if(!vis[i]) dfs(i,A,ans+A[i]+"");
vis[s]=false;
}
}
public String largestTimeFromDigits(int[] A) {
vis = new boolean[4];
max="0000";
for(int i=0; i<4; i++){
dfs(i,A,A[i]+"");
}
if(max.equals("0000") && !isPossible) return "";
return max.substring(0,2)+":"+max.substring(2,4);
}
}
