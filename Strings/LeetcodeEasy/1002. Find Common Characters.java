/* Question:
Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.

 

Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]
 

Note:

1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] is a lowercase letter  */

//Solution
class Solution {
    public List<String> commonChars(String[] A) {
        List<String> ans=new ArrayList<>();
        
        int[] min_frequencies=new int[26];
        Arrays.fill(min_frequencies,Integer.MAX_VALUE);
        
        for(String s:A){
            
            int[] char_frequencies=new int[26];
            
            for(char c:s.toCharArray()){
                char_frequencies[c-'a']++;
            }
            
            for(int i=0;i<26;i++){
                min_frequencies[i]=Math.min(min_frequencies[i],char_frequencies[i]);
            }
        }
        
        for(int i=0;i<26;i++){
            while(min_frequencies[i]>0){
                ans.add(""+(char)(i+'a'));
                min_frequencies[i]--;}
            }
        return ans;
        }
    }
