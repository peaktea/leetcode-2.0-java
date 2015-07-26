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
	private int getheight(TreeNode root){
		if(root==null) return 0;
		int lefth=getheight(root.left)+1;
		int righth=getheight(root.right)+1;
		//below is corner case. if the sub tree is not balanced, then just return.
		if(lefth==0||righth==0) return -1;
		int diff=Math.abs(lefth-righth);
		if(diff>1){return -1;}
		else{
			return Math.max(lefth,righth);
		}
	}
    public boolean isBalanced(TreeNode root) {
        int height = getheight(root);
		if(height==-1) return false;
		else return true;
    }
}