/* Question:
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. You can return the output in any order.

 

Example 1:

Input: S = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:

Input: S = "3z4"
Output: ["3z4","3Z4"]
Example 3:

Input: S = "12345"
Output: ["12345"]
Example 4:

Input: S = "0"
Output: ["0"]
 

Constraints:

S will be a string with length between 1 and 12.
S will consist only of letters or digits.  */

//Solution
class Solution {
    List<String> ans;
    public List<String> letterCasePermutation(String S) {
        ans=new ArrayList<>();
        int n=S.length();
        solve(new StringBuilder(S),0,n);
        return ans;
    }
    
    private boolean solve(StringBuilder s,int start,int n){
        ans.add(s.toString());
        for(int i=start;i<n;i++){
            char c=s.charAt(i);
            if(Character.isLetter(c))
            { if(Character.isLowerCase(c))
               {  s.setCharAt(i,Character.toUpperCase(c));
                  solve(s,i+1,n);
                  s.setCharAt(i,Character.toLowerCase(c));}   
             else{
                s.setCharAt(i,Character.toLowerCase(c));
                solve(s,i+1,n);
                s.setCharAt(i,Character.toUpperCase(c));}
            }
        }
        return false;
    }
}

//Solution
class Solution {
    public List<String> letterCasePermutation(String S) {
        
        List<String> result= new ArrayList<>();

        getAllPossible(result,new StringBuilder(S),0,S.length());
        
        return result;
    }
    
    
    public void  getAllPossible(List<String>result,StringBuilder ss,int index,int n){
        
        if(index ==n){
           
                result.add(ss.toString());
                return;
            
        }
        
        if(ss.charAt(index)>='0' && ss.charAt(index)<='9'){
           
            getAllPossible(result,ss,index+1,n);
            
        } 
        else{
            char ch = ss.charAt(index);
            ss.setCharAt(index,Character.toLowerCase(ch));
            getAllPossible(result,ss,index+1,n);
            ss.setCharAt(index,Character.toUpperCase(ch));
            getAllPossible(result,ss,index+1,n);
        }
        
    }
}
