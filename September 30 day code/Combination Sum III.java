/* Problem:
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]] */

//Solution(1 ms)

class Solution{
    //List to store final result
    List<List<Integer>> res = new ArrayList<>();
    
    //dfs traversal
    public void dfs(int k, int n, int i, List<Integer> lst, int ans) {
        
        //ans will store curent running sum of values which are there in lst
        ans += i;
        lst.add(i);
        k--;
        
        //result condition add list to res
        if(k == 0 && ans == n) {
            res.add(lst);
        }
        if((k<0 || ans>n) || (k==0 && ans!=n))  return;
        
        //further dfs traversal, start from curent i + 1 value
        for(int j = i+1; j < 10; j++) {
            dfs(k, n, j, new ArrayList<Integer>(lst), ans);
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        res.clear();
        
        for(int i = 1; i < 10; i++) {
            List<Integer> lst = new ArrayList<>();
            dfs(k, n, i, lst, 0);
        }
        return res;
    }}
