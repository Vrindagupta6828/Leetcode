/* Problem:
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.  */

//My Solution(3 ms)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0 || strs[0]==null || strs[0].isEmpty()) return "";
        int j=0;String common="";
        try{ while(j<strs[0].length()){
            common=strs[0].substring(0,j+1);j++;
        for(int i=0;i<strs.length;i++){
            if(!strs[i].substring(0,common.length()).equals(common)) 
                return common.substring(0,common.length()-1);
        }}   return common; 
           }
        catch(Exception e){
            return common.substring(0,common.length()-1);
        }
    }
}

//Solution(0 ms)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";
        String prev=strs[0]; int i=1;
        while(i< strs.length){
            while(strs[i].indexOf(prev)!=0)
                prev=prev.substring(0,prev.length()-1);
            i++;
        }
        return prev;
    }
}
