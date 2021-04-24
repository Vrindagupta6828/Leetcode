/* Question:
Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.

 

Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
 

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?  */

//Solution 1(o(n))
class Solution {
    ArrayList<Integer> arr;
    public int kthSmallest(TreeNode root, int k) {
        arr=new ArrayList<>();
        inorder(root);
        return arr.get(k-1);
    }
    
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }
}

//Solution 2(o(h+k) time and o(h) space)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack=new Stack<>();
        while(true){
            while(root!=null){
                stack.add(root);
                root=root.left;
            }
            root=stack.pop();
            if(--k==0) return root.val;
            root=root.right;
        }
   }
}
