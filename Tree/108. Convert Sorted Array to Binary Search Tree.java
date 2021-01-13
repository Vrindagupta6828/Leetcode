/* Question:
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5  */
 
 //Solution 1(taking left middle in even no. of elements)(o(N) time and space)(space o(n) to keep ans and o(log n) for recursion stack)
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
    int[] nums;
    
    public TreeNode sortedArrayToBST(int[] nums) {
       this.nums=nums;
        return helper(0,nums.length-1);
    }
    
    private TreeNode helper(int left,int right){
        if(left>right)
            return null;
        int p=(left+right)/2;
        TreeNode root=new TreeNode(nums[p]);
        root.left=helper(left,p-1);
        root.right=helper(p+1,right);
        return root;
    }
}

//Solution 2(taking right middle same complexity)
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
    int[] nums;
    
    public TreeNode sortedArrayToBST(int[] nums) {
       this.nums=nums;
        return helper(0,nums.length-1);
    }
    
    private TreeNode helper(int left,int right){
        if(left>right)
            return null;
        int p=(left+right)/2;
        if(left+right%2==1) ++p;
        TreeNode root=new TreeNode(nums[p]);
        root.left=helper(left,p-1);
        root.right=helper(p+1,right);
        return root;
    }
}
