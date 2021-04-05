/* Question:
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lower-case English letters.  */

//Solution(o(nklogk) time and o(nk) space)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> grp=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] c=strs[i].toCharArray();
            Arrays.sort(c);
            String s=String.valueOf(c);
            if(grp.containsKey(s)) grp.get(s).add(strs[i]);
            else{
                List<String> temp=new ArrayList<>();
                temp.add(strs[i]);
                grp.put(s,temp);
            }
        }
        List<List<String>> ans=new ArrayList<>();
        for(String k:grp.keySet()){
            ans.add(grp.get(k));
        }
        return ans;
    }
}
