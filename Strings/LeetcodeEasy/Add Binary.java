/* Question:
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"   */

//Solution(o(n))
class Solution {
    public String addBinary(String a, String b) {
        int i=a.length()-1,j=b.length()-1,s=0;
        StringBuilder sb=new StringBuilder();
        while(i>=0||j>=0||s==1){
            s+=(i>=0)?(a.charAt(i)-'0'):0;
            s+=(j>=0)?(b.charAt(j)-'0'):0;
            
            sb.insert(0,(char)(s%2+'0'));
            s/=2;
            i--;j--;
        }
        return sb.toString();
        }
}
