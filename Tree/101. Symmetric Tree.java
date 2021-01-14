/* Question:
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 

Follow up: Solve it both recursively and iteratively.   */

//Solution
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return(isSymmetric(root,root));
        
    }
    
    private boolean isSymmetric(TreeNode a,TreeNode b){
        if(a==null && b==null) return true;
        if(a!=null && b!=null && a.val==b.val)
           return isSymmetric(a.left,b.right) && isSymmetric(a.right,b.left);
        return false;
    }
}

//Solution
class Solution {
    public boolean isSymmetric(TreeNode root) {
       Queue<TreeNode> q=new LinkedList<>();
       q.add(root);
       q.add(root);
       while(!q.isEmpty()){
           TreeNode a=q.poll();
           TreeNode b=q.poll();
           if(a==null && b==null) continue;
           if(a==null || b==null) return false;
           if(a.val!=b.val) return false;
           q.add(a.left);
           q.add(b.right);
           q.add(a.right);
           q.add(b.left);
       }
        return true;
    }
}
