/* Question:
Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.    */

//Solution 1(O(n) time and O(1) space)
class Solution {
    public int firstUniqChar(String s) {
       int[] freq=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']==1)
                return i;
        }
        return -1;
    }
}

//Solution 2
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int index=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1)
                return i;
        }
        return -1;
    }
}
