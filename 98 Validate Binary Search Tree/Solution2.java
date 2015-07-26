/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	TreeNode preone=null;
	private boolean inorder(TreeNode root){
		if(root==null) return true;
		//visit left
		if(!inorder(root.left)) return false;
		//visit current
		//in fact, the below code is a corner case, if the left most value is just the Integer.MIN_VALUE, then it is difficult 
		//to determine the correctness, because the algorithm does not know which one is the left most node.
		//but for the left most node, we can just pass it, because it is the first, it is correctness in common.
		if(preone!=null&&root.val<=preone.val) return false;
		preone=root;
		//visit right
		if(!inorder(root.right)) return false;
		return true;
	}
    public boolean isValidBST(TreeNode root) {
		preone=null;
		return inorder(root);
    }
}