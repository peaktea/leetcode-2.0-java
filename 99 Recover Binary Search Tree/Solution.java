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
 The way to solve the problem is to seen the node which destroy the monotonicity of the data values.
 we just need to change the values of them.
 */
public class Solution {
	TreeNode first=null;
	TreeNode second=null;
	TreeNode pre=null;
    public void find(TreeNode root) {
        if(root==null) return;
		find(root.left);
		if(pre!=null&&root.val<pre.val){
			if(first==null){
				//here is a good corner case
				//0 1
				//the two consecutive numbers are swapped, so we should record the candidate second node.
				first=pre;
				second=root;
			}
			else {
				second=root;
			}
		}
		pre=root;
		find(root.right);
    }
	public void recoverTree(TreeNode root){
		first=null;
		second=null;
		find(root);
		int tmp=first.val;
		first.val=second.val;
		second.val=tmp;
	}
}