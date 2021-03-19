/* Question:
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100  */

//Solution:
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> q1=new Stack<>();
        Stack<TreeNode> q2=new Stack<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        q1.push(root);
        while(!q1.isEmpty() || !q2.isEmpty()){
            
            if(!q1.isEmpty()){
                int s=q1.size();
                List<Integer> temp=new ArrayList<>();
                for(int i=0;i<s;i++)
                {   TreeNode curr=q1.pop();
                    temp.add(curr.val);
                    if(curr.left!=null) q2.push(curr.left);
                    if(curr.right!=null) q2.push(curr.right);
                }
                ans.add(temp);
            }
            
            if(!q2.isEmpty()){
                int s=q2.size();
                List<Integer> temp=new ArrayList<>();
                for(int i=0;i<s;i++)
                {   TreeNode curr=q2.pop();
                    temp.add(curr.val);
                    if(curr.right!=null) q1.push(curr.right);
                    if(curr.left!=null) q1.push(curr.left);
                }
                ans.add(temp);
            }
        }
        return ans;
    }
}
