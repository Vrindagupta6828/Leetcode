/* Question:
Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

Example 1:
Input: "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

Notice that some of these substrings repeat and are counted the number of times they occur.

Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
Example 2:
Input: "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
Note:

s.length will be between 1 and 50,000.
s will only consist of "0" or "1" characters.   */

//Solution1: o(n)
class Solution {
    public int countBinarySubstrings(String s) {
        int result=0;
        int[] count=new int[2];
        char check=s.charAt(0);
        count[s.charAt(0)-'0']++;
        for(int i=1;i<s.length();i++){
            count[s.charAt(i)-'0']++;
            if(s.charAt(i)==check)
            { check=s.charAt(i-1); 
             if(s.charAt(i)!=s.charAt(i-1)) count[s.charAt(i)-'0']=1;}
            if(s.charAt(i)=='1' && count[1]<=count[0] && count[0]!=0) result++;
            else if(s.charAt(i)=='0' && count[0]<=count[1] && count[1]!=0) result++;
        }
        return result;
    }
}

//Solution 2(o(n) time and space)
class Solution {
    public int countBinarySubstrings(String s) {
        int[] groups = new int[s.length()];
        int t = 0;
        groups[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                groups[++t] = 1;
            } else {
                groups[t]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= t; i++) {
            ans += Math.min(groups[i-1], groups[i]);
        }
        return ans;
    }
}

//Solution 3(o(n) time and o(1) space)
class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return ans + Math.min(prev, cur);
    }
}
