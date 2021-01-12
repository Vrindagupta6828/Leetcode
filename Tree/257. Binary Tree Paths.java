/* Question:
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3  */

//Solution(O(n) time )
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
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans=new ArrayList<>();
        traverse(root,new StringBuilder());
        return ans;
    }
    
    public void traverse(TreeNode root,StringBuilder s){
        if(root==null)
            return;
        if(root.left==null && root.right==null)
        {   s.append(root.val);
            ans.add(s.toString());
            return;
        }
        else
        {
            s.append(root.val);
            s.append("->");
            traverse(root.left,new StringBuilder(s));
            traverse(root.right,new StringBuilder(s));
        }
    }
}
