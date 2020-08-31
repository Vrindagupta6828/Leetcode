/* Problem

Dhruvil has always been a studious person and will be completing his Engineering soon. He is always kneen about solving problems and is preparing hard for his next interview at Hackerrank. He has practiced lots of problems and now he came across this problem.

Given a message containing English letters(A-Z), it is being encoded to numbers using the following mapping: 'A' -> 1,'B' -> 2 ……………… 'Z' -> 26.

Now, given a non-empty string containing only digits, help Dhruvil determine the total number of ways to decode it.

While decoding you need to choose a substring of charachters and not a subsequence. Also a chosen substring should not contain any leading "0"s, but can contain trailing "0"s. Since the output can be very large print the answer as modulo 10^9 + 7 i.e 1000000007.

Input:
The first line of the input consists of single integer T, the number of test cases.Each test case consists of a string.

Output:
For each test case print a single integer - the total number of ways to decode the digit string.

Constraints
1≤T≤1000
2≤S≤109
Sample Input:
2
12
226

Sample Output:
2
3

EXPLANATION:
There are 2 possible ways. It could be decoded as "AB" {1,2} or "L" {12}.

There are 3 possible ways. It could be decoded as "BZ" {2,26}, "VF" {22,6}, or "BBF" {2,2,6}.
*/

//Solution

import java.io.IOException;
import java.util.*;


class temp2 {
	static long mod=1000000007;

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			
			String s=scn.next();
			long ans=0;
//			long dp[]=new long[s.length+1];
//			dp[0]=1;
//			for(int i=1;i<=s.length;i++){
//				dp[i]=dp[i-1]%mod;
//				
//				if(i-2>=0){
//					int val=(s[i-2]-'0')*10+(s[i-1]-'0');
//					if(val>0 && val<27){
//						dp[i]=(dp[i]+dp[i-2])%mod;
//					}
//				}
//			}
			ans=numDecodings(s);
      	sb.append(ans + "\n");
		}
		System.out.println(sb);

	}
	public static long numDecodings(String s) {
        int length = s.length();
        if (length == 0) return 0;
        long prev = 1;
        long curr = s.charAt(length - 1) == '0' ? 0 : 1;
        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                prev = curr;
                curr = 0;
            } else {
                 long count = 0;
                if (Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                    count =(count+ prev)%mod;
                }
                count= (curr+count)%mod;
                prev = curr;
                curr = count;
            }
        }
        return curr%mod;
    }
}
