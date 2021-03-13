/* Question:
Given an array of strings, return all groups of strings that are anagrams. The groups must be created in order of their appearance in the original array. Look at the sample case for clarification.


Example 1:

Input:
N = 5
words[] = {act,god,cat,dog,tac}
Output: 
god dog
act cat tac
Explanation:
There are 2 groups of
anagrams "god", "dog" make group 1.
"act", "cat", "tac" make group 2.
Example 2:

Input:
N = 3
words[] = {no,on,is}
Output: 
no on
is
Explanation:
There are 2 groups of
anagrams "no", "on" make group 1.
"is" makes group 2. 

Your Task:
The task is to complete the function Anagrams() that takes a list of strings as input and returns a list of groups such that each group consists of all the strings that are anagrams.


Expected Time Complexity: O(N*|S|*log|S|), where |S| is the length of the strings.
Expected Auxiliary Space: O(N*|S|), where |S| is the length of the strings.


Constraints:
1<=N<=100   */

//Solution:
class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        
        // Your Code here
        List<List<String>> ans=new ArrayList<>();
        HashMap<String,ArrayList<String>> wrds=new HashMap<>();
        int n=string_list.length;
        
        for(int i=0;i<n;i++){
            char[] temp=string_list[i].toCharArray();
            Arrays.sort(temp);
            String s=new String(temp);
            if(wrds.containsKey(s))
                 wrds.get(s).add(string_list[i]);
            else{
                 ArrayList<String> t=new ArrayList<>();
                 t.add(string_list[i]);
                 wrds.put(s,t);
            }
        }
        
        for(String k:wrds.keySet()){
               ans.add(wrds.get(k));
        }
        
        return ans;
        
    }
}

Expected Time Complexity: O(N*|S|*log|S|), where |S| is the length of the strings.
Expected Auxiliary Space: O(N*|S|), where |S| is the length of the string
