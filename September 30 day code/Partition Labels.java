/*Problem:
A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 

Note:

S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only. */

//Solution (HashMap automatically sort it's key if they are characters) My Solution (5 ms better than 59%)

class Solution {
    public List<Integer> partitionLabels(String S) {
        HashMap<Character,ArrayList<Integer>> a=new HashMap<>();
        List<Character> seq=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<S.length();i++){
            if(!a.containsKey(S.charAt(i)))
            {a.put(S.charAt(i), new ArrayList<Integer>()); seq.add(S.charAt(i));}
            a.get(S.charAt(i)).add(i);
        }
        
        int max=a.get(S.charAt(0)).get(a.get(S.charAt(0)).size()-1);int prev=0;
        for(int i=0;i<seq.size();i++){
            if(a.get(seq.get(i)).get(0)<max){
                if(a.get(seq.get(i)).get(a.get(seq.get(i)).size()-1)>max)  max=a.get(seq.get(i)).get(a.get(seq.get(i)).size()-1);
            }
            else if(seq.get(i)!=S.charAt(0)){
                res.add(max+1-prev);
                prev=max+1;
                max=a.get(seq.get(i)).get(a.get(seq.get(i)).size()-1);
            }}
        res.add(max+1-prev);
        return res;
    }
}

//Solution(3ms 90%)
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++)
            lastIndex[S.charAt(i) - 'a'] = i;

        List<Integer> result = new ArrayList();
        int j = 0, subStrStart = 0;
        for (int i = 0; i < S.length(); i++) {
            j = Math.max(j, lastIndex[S.charAt(i) - 'a']);
            if (i == j) {
                result.add(i - subStrStart + 1);
                subStrStart = i + 1;
            }
        }

        return result;
    }
}
