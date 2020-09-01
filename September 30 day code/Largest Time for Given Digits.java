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

//Solution 2 ms

class Solution {
    public String largestTimeFromDigits(int[] A) {
    
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {

				if (j != i) {
					for (int k = 0; k < A.length; k++) {

						if (k != i && k != j) {
							int l = 6 - i - j - k;

							int hrs = A[i] * 10 + A[j];
							int mins = A[k] * 10 + A[l];

							if (hrs < 24 && mins < 60) {

								max = Math.max(hrs * 100 + mins, max);
							}

						}

					}
				}
			}

		}

		StringBuilder sb = new StringBuilder(String.valueOf(max));
	 if (max < 9) {
			sb.insert(0, "000");

		} else if (max < 99) {
			sb.insert(0, "00");

		} else

		if (max < 999) {
			sb.insert(0, "0");
		}

		sb.insert(2, ":");

		return max == Integer.MIN_VALUE ? "" : sb.toString();
    }
}
