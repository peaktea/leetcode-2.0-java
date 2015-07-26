/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*
 the corner case here occurs when one subtree is empyt, then heigt is not 0, but the height of another substree
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
		if(root.left==null&&root.right==null) return 1;
		int leftheight=Integer.MAX_VALUE;
		if(root.left!=null){
			leftheight=minDepth(root.left)+1;
		}
		int rightheight=Integer.MAX_VALUE;
		if(root.right!=null){
			rightheight=minDepth(root.right)+1;
		}
		return Math.min(leftheight,rightheight);
    }
}