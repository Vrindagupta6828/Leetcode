/* Question:
Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

 

Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
Example 3:

Input: name = "leelee", typed = "lleeelee"
Output: true
Example 4:

Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.
 

Constraints:

1 <= name.length <= 1000
1 <= typed.length <= 1000
The characters of name and typed are lowercase letters.   */

//Solution 1(o(n+t) time and space)
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        Group g1 = groupify(name);
        Group g2 = groupify(typed);
        if (!g1.key.equals(g2.key))
            return false;

        for (int i = 0; i < g1.count.size(); ++i)
            if (g1.count.get(i) > g2.count.get(i))
                return false;
        return true;
    }

    public Group groupify(String S) {
        StringBuilder key = new StringBuilder();
        List<Integer> count = new ArrayList();
        int anchor = 0;
        int N = S.length();
        for (int i = 0; i < N; ++i) {
            if (i == N-1 || S.charAt(i) != S.charAt(i+1)) { // end of group
                key.append(S.charAt(i));
                count.add(i - anchor + 1);
                anchor = i+1;
            }
        }
         return new Group(key.toString(), count);
    }
}

class Group {
    String key;
    List<Integer> count;
    Group(String k, List<Integer> c) {
        key = k;
        count = c;
    }
    
    //Solution 2(o(n+t) time and space)
    class Solution {
    public boolean isLongPressedName(String name, String typed) {

        // two pointers to the "name" and "typed" string respectively
        int np = 0, tp = 0;
        // convert the string to array of chars, for ease of processing later.
        char[] name_chars = name.toCharArray();
        char[] typed_chars = typed.toCharArray();

        // advance two pointers, until we exhaust one of the strings
        while (np < name_chars.length && tp < typed_chars.length) {
            if (name_chars[np] == typed_chars[tp]) {
                np += 1;
                tp += 1;
            } else if (tp >= 1 && typed_chars[tp] == typed_chars[tp - 1]) {
                tp += 1;
            } else {
                return false;
            }
        }

        // if there is still some characters left *unmatched* in the origin string,
        // then we don't have a match.
        // e.g. name = "abc" typed = "aabb"
        if (np != name_chars.length) {
            return false;
        } else {
            // In the case that there are some redundant characters left in typed
            // we could still have a match.
            // e.g. name = "abc" typed = "abccccc"
            while (tp < typed_chars.length) {
                if (typed_chars[tp] != typed_chars[tp - 1])
                    return false;
                tp += 1;
            }
        }

        // both strings have been consumed.
        return true;
    }
}
  
