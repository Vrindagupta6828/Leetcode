/* Question:
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.  */

//Solution
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
    int max=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        traverse(root);
        return max==Integer.MIN_VALUE?0:max;
    }
    
    private int traverse(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;
        int left,right;
         if(root.left==null) left=0;
         else   left=1+traverse(root.left);
         if(root.right==null) right=0;
         else right=1+traverse(root.right);
         max=Math.max(max,left+right);
         return Math.max(left,right);
    }
}

//Solution 2
class Solution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }
}
