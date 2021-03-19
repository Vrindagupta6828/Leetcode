/* Question:
Given an input stream of A of n characters consisting only of lower case alphabets. The task is to find the first non repeating character, each time a character is inserted to the stream. If there is no such character then append '#' to the answer.
 

Example 1:

Input: A = "aabc"
Output: "a#bb"
Explanation: For every character first non
repeating character is as follow-
"a" - first non-repeating character is 'a'
"aa" - no non-repeating character so '#'
"aab" - first non-repeating character is 'b'
"aabc" - first non-repeating character is 'b'
Example 2:

Input: A = "zz"
Output: "z#"
Explanation: For every character first non
repeating character is as follow-
"z" - first non-repeating character is 'z'
"zz" - no non-repeating character so '#'
 

Your Task:
You don't need to read or print anything. Your task is to complete the function FirstNonRepeating() which takes A as input parameter and returns a string after processing the input stream.
 

Expected Time Complexity: O(26 * n)
Expected Space Complexity: O(26)
 

Constraints:
1 <= n <= 105  */

//Solution:
class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        boolean[] freq=new boolean[26];
        int n=A.length();
        ArrayList<Character> q=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<n;i++){
            if(!freq[A.charAt(i)-'a']){
                if(!q.contains(A.charAt(i))){
                    q.add(A.charAt(i));
                }
                else{
                    q.remove(new Character(A.charAt(i)));
                    freq[A.charAt(i)-'a']=true;
                }
            }
            if(q.size()>0) sb.append(q.get(0));
            else   sb.append('#');
        }
        return sb.toString();
    }
}
