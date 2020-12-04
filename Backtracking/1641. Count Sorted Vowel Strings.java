/* Question:
Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

 

Example 1:

Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
Example 2:

Input: n = 2
Output: 15
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
Example 3:

Input: n = 33
Output: 66045
 

Constraints:

1 <= n <= 50   */

//Solution 1(O(n^5))
class Solution {
    int count=0;
    public int countVowelStrings(int n) {
        solve(n,0);
        return count;
        }
    
    private boolean solve(int n,int pos){
        if(n==0){
            count++;
            return true;
        }
        for(int i=pos;i<5;i++){
            solve(n-1,i);
        }
        return false;
    }
}

//Solution 2
The problem is a variant of finding Combinations. Mathematically, the problem can be described as, given 5 vowels (let k = 5k=5), we want to find the number of combinations using only nn vowels. Also, we can repeat each of those vowels multiple times.

In other words, from kk vowels (k = 5k=5), we can choose nn vowels with repetition. Denoted as \left(\!\!{k \choose n}\!\!\right)(( 
n
k
​	
 )), the formulae for Combination with Repetition is given by,
 

The derivation can be illustrated as follows.

{kCn}

Implementation:
class Solution {
    public int countVowelStrings(int n) {
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
    }
}

Complexity Analysis

Time Complexity: \mathcal{O}(1)O(1), as the approach runs in constant time.

Space Complexity: \mathcal{O}(1)O(1), as the approach uses constant extra space.

//Solution 3(o(n^5))
class Solution {
    public int countVowelStrings(int n) {
        return countVowelStringUtil(n, 5);
    }

    int countVowelStringUtil(int n, int vowels) {
        if (n == 1)
            return vowels;
        if (vowels == 1)
            return 1;
        return countVowelStringUtil(n - 1, vowels) +
                countVowelStringUtil(n, vowels - 1);
    }
}
