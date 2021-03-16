/* Question:
Given a Binary Tree. Check whether it is a Sum Tree or not.

A Binary Tree is a Sum Tree in which value of each node x is equal to sum of nodes present in its left subtree and right subtree . An empty tree is also a Sum Tree as sum of an empty tree can be considered to be 0. A leaf node is also considered as a Sum Tree.

Example 1:

Input:
    3
  /   \    
 1     2

Output: 1
Explanation: The given tree is a sum 
tree so return a boolean true.

Example 2:

Input:

          10
        /    \
      20      30
    /   \ 
   10    10

Output: 0
Explanation: The given tree is not a sum
tree. For the root node, sum of elements
in left subtree is 40 and sum of elements
in right subtree is 30. Root element = 10
which is not equal to 30+40.

Your Task: 
You dont need to read input or print anything. Complete the function isSumTree() which takes root node as input parameter and returns true if the tree is a SumTree else it returns false.
 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of the Tree)


Constraints:
1 ≤ number of nodes ≤ 104   */

//Solution
class Solution
{   boolean flag=true;

	boolean isSumTree(Node root)
	{
             // Your code here
             traverse(root);
             return flag;
             
	}
	
	int traverse(Node root){
	    if(root==null || !flag) return 0;
	    int leftsum=traverse(root.left);
	    int rightsum=traverse(root.right);
	    if((root.left!=null || root.right!=null) &&
	        root.data==leftsum+rightsum)
	        return root.data+leftsum+rightsum;
	    else if(root.left==null && root.right==null)
	       return root.data;
	    else{ flag=false; return 0;}
	}
