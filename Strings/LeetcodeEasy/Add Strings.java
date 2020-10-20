/* Question:
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.  */

//Solution(o(max(n1,n2)) time and space)
class Solution {
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1,j=num2.length()-1,s=0;
        StringBuilder sb=new StringBuilder();
        while(i>=0||j>=0||s>0){
            s+=(i>=0)?(num1.charAt(i)-'0'):0;
            s+=(j>=0)?(num2.charAt(j)-'0'):0;
            sb.insert(0,(char)(s%10+'0'));
            s/=10;
            i--;j--;
        }
        return sb.toString();
    }
}
