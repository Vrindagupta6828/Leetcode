/* Question:
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30  */

//Solution
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans=new ArrayList<List<Integer>>();
        LinkedList<Integer> temp= new LinkedList<>();
        Arrays.sort(candidates);
        solve(candidates,target,temp,0);
        return ans;
    }
    
    private boolean solve(int[] candidates,int target,LinkedList<Integer> temp,int start){
        if(target==0){
            if(!ans.contains(temp)) 
            ans.add(new ArrayList<Integer>(temp));
            return true;
        }
        for(int i=start;i<candidates.length;++i){
            if(target-candidates[i]>=0)
            {temp.add(candidates[i]);
             solve(candidates,target-candidates[i],temp,i+1);
             temp.removeLast();
            }
        }
        return false;
    }
}
