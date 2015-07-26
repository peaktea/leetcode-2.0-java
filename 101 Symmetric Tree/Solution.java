/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 import java.util.*;
 
public class Solution {
	private boolean Recursive(TreeNode left, TreeNode right){
		if(left==null&&right==null) return true;
		if(left==null||right==null) return false;
		if(left.val!=right.val) return false;
		return Recursive(left.left,right.right)&&Recursive(left.right,right.left);
	}
	private boolean Iterative(TreeNode root){
		Stack<TreeNode> stackleft = new Stack<TreeNode>();
		Stack<TreeNode> stackright = new Stack<TreeNode>();
		stackleft.push(root.left);
		stackright.push(root.right);
		while(!stackleft.isEmpty()&&!stackright.isEmpty()){
			TreeNode left=stackleft.pop();
			TreeNode right=stackright.pop();
			if(left==null&&right==null) continue;
			if(left==null||right==null) return false;
			if(left.val!=right.val) return false;
			stackleft.push(left.right);stackleft.push(left.left);
			stackright.push(right.left);stackright.push(right.right);
		}
		return true;
	}
    public boolean isSymmetric(TreeNode root) {
		if(root==null) return true;
        return Recursive(root.left,root.right);
		//return Iterative(root);
    }
}