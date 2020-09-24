/* Problem:
Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
 

Note: You may assume the string contains only lowercase English letters.  */

//My Solution
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int index=Integer.MAX_VALUE;
        for(int i=s.length()-1;i>=0;i--){
                 map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            }
        for(Character c:map.keySet()){
            if(map.get(c)==1 && s.indexOf(c)<index)  index=s.indexOf(c);
        }
        if(index==Integer.MAX_VALUE) return -1;
        return index;
    }
}

//Solution( 3 ms 98%)

class Solution {
    public int firstUniqChar(String s) {
        
        if(s == null || s.length() == 0)
            return -1;
        
        int ans = Integer.MAX_VALUE;
        for(char ch = 'a'; ch <= 'z'; ch++){
            
            int index = s.indexOf(ch);
            
            if(index != -1 && index == s.lastIndexOf(ch))
                ans = Math.min(ans, index);
            
        }
        
        return (ans == Integer.MAX_VALUE) ? -1 : ans; 
    }
}
