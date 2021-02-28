/* Question:
Problem Description

Given a column title A as appears in an Excel sheet, return its corresponding column number.



Problem Constraints
1 <= |A| <= 100



Input Format
First and only argument is string A.



Output Format
Return an integer



Example Input
Input 1:

 1
Input 2:

 28


Example Output
Output 1:

 "A"
Output 2:

 "AB"


Example Explanation
Explanation 1:

 1 -> "A"
Explanation 2:

A  -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28   */

//Solution 1
public class Solution {
    public int titleToNumber(String A) {
        
        int n=A.length();
        int ans=0;
        for(int i=0;i<n;i++){
            ans*=26;
            ans+=(A.charAt(i)-64);
        }
        return ans;
    }
}

//Solution 2
public class Solution {
	public int titleToNumber(String a) {
	    int num = 0;
	    for (int i = a.length() - 1, j = 0; i >= 0; i--) {
	        num += (int) Math.pow(26, j) * (a.charAt(i) - 'A' + 1);
	        j++;
	    }
	    return num;
	}
}
