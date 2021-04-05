/* Question:
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8   */

//Solution
class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans=new ArrayList<>();
        solve(n,"",0,0);
        return ans;
    }
    
    public void solve(int n,String s,int open,int close){
        if(open+close==2*n) {ans.add(s); return;}
        if(open<n) solve(n,s+"(",open+1,close);
        if(close<open) solve(n,s+")",open,close+1);
    }
}
