/* Question:
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 

Note:

There are at least two nodes in this BST.
This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/   */

//Solution
class Solution {
    TreeNode last=new TreeNode(Integer.MAX_VALUE);
    int min=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root==null) return min;
        getMinimumDifference(root.left);
        min=Math.min(min,Math.abs(last.val-root.val));
        last=root;
        getMinimumDifference(root.right);
        return min;
    }
}
