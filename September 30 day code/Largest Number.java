/* Problem:
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.  */

//Solution(4 ms 99% better)

/*Convert int[] to String [].
Sort the String[] using custom comparator, compare string based on concatenations and result in descending order.
Join all String in 1 using StringBuider
Check if this string consist only 0 then return "0" else string. */

class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] s = new String[n];
        for(int i = 0; i < n; i++)
            s[i] = String.valueOf(nums[i]);
        
        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));
        
        StringBuilder sb = new StringBuilder();
        for(String str : s)
            sb.append(str);
        String result = sb.toString();
        return result.startsWith("0") ? "0" : result;
    }
}
