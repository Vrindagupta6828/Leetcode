/* Question:
Given a string s and a string t, check if s is subsequence of t.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 

Constraints:

0 <= s.length <= 100
0 <= t.length <= 10^4
Both strings consists only of lowercase characters.   */

//Solution(o(n) time and o(1) space)
class Solution {
    public boolean isSubsequence(String s, String t) {
       int i=0,j=0;
       while(i<s.length() && j<t.length()){
           if(s.charAt(i)==t.charAt(j))
           i++;
           j++;
       }
        return(i==s.length());
    }
}

Solution 2(o(nlogn))
 class Solution {
    public boolean isSubsequence(String s, String t) {
        int tlength=t.length(),slength=s.length(); 
        if(slength==0) return true;
        if(tlength==0) return false;
        HashMap<Character,List<Integer>> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i)))
                map.put(t.charAt(i),new ArrayList<>());
                map.get(t.charAt(i)).add(i);
        }
        int lastindx=-1;
        for(int i=0;i<slength;i++){
            if(map.containsKey(s.charAt(i)))
            {int foundvalue=-1;
            List<Integer> list=new ArrayList<>();
            list=map.get(s.charAt(i));
            int low=0,high=list.size()-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(list.get(mid)>lastindx)
                {foundvalue=list.get(mid);
                    high=mid-1;}
                else low=mid+1;
            }
             if(foundvalue>lastindx)
                 lastindx=foundvalue;
             else return false;
        }
            else return false;}
        return true;
    } 
}




