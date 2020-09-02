/* Problem:
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11 */

//Solution (100% better 2 ms)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSumHelper(TreeNode root, int tsum,int csum,HashMap<Integer,Integer>map) 
    {
        
        if(root==null)
            return 0;
        int count=0;
        csum+=root.val;
        if(map.containsKey(csum-tsum))
            count+=map.get(csum-tsum);
      
        map.put(csum,map.getOrDefault(csum,0)+1);
        count+=pathSumHelper(root.left,tsum,csum,map);
        count+=pathSumHelper(root.right,tsum,csum,map);
		//Before going back, need to remove it from hashmap, as it will not be counted again
        map.put(csum,map.get(csum)-1);
        return count; 
    }
    
     public int pathSum(TreeNode root, int sum)
     {
       
         HashMap<Integer,Integer>map=new HashMap<>();
		 //so that if node with value equal to target comes, that can be added to count
         map.put(0,1);
         return pathSumHelper(root,sum,0,map);    
     }
}
