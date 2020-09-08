/* Problem:
Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers.

 

Example 1:



Input: [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 

Note:

The number of nodes in the tree is between 1 and 1000.
node.val is 0 or 1.
The answer will not exceed 2^31 - 1. */

//My Solution(1 ms 50%)

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
    int sum=0;
    public int sumRootToLeaf(TreeNode root) {
        traverse(root,"");
        return sum;
    }
    private void traverse(TreeNode root,String s){
        if(root==null)  return;
        s+=Integer.toString(root.val);
        if (root.left == null && root.right == null) 
            sumfunc(s);
        else{traverse(root.left,s);
        traverse(root.right,s);    
    }
        }
    private void sumfunc(String s){
        int f=Integer.parseInt(s,2);
        sum+=f;
    }
}

//Solution (0ms 100%)
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
    
    public int sumRootToLeafUtil(TreeNode root, int val) {
        if(root == null)
            return 0;
        
        val = val * 2 + root.val;
        
        //if leaf node
        if(root.left == null && root.right == null) {
            return val;
        }
        
        return sumRootToLeafUtil(root.left, val)
                 + sumRootToLeafUtil(root.right, val);
    }
    
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeafUtil(root, 0);
    }
}
