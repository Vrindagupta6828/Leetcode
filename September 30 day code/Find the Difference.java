/*Problem:
Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.

Example:

Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.   */

//My Solution(3 ms)
class Solution {
    public char findTheDifference(String s, String t) {
        char[] a=s.toCharArray();Arrays.sort(a);
        char[] b=t.toCharArray();Arrays.sort(b);
        for(int i=0;i<a.length;i++){
            if(Character.compare(a[i],b[i])!=0)
                return b[i];
        }
        return b[b.length-1];
    }
}

//Solution(0 ms)\
class Solution {
    public char findTheDifference(String s, String t) {
		int sumS = 0, sumT = 0;
		char[] arrS = s.toCharArray();
		char[] arrT = t.toCharArray();
		for (int i = 0; i < arrS.length; i++) {
			sumS += arrS[i] - 'a';
			sumT += arrT[i] - 'a';
		}
		sumT += arrT[arrT.length - 1] - 'a';
		return (char) (sumT - sumS + 'a');
	}
}
