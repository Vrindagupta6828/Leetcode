/* Question:
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

 

Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:


Input: nums = [1,3]
Output: [3,1]
Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.   */

//Solution
class Solution {
    
    public TreeNode sortedArrayToBST(int[] nums) {
       return arraytoTree(nums,0,nums.length-1);
    }

    private TreeNode arraytoTree(int[] nums,int start,int end){
        if(start>end) return null;
        int p=(start+end)/2;
        TreeNode root=new TreeNode(nums[p]);
        if(start==end) return root;
        root.left=arraytoTree(nums,start,p-1);
        root.right=arraytoTree(nums,p+1,end);
        return root;
    }
}
