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
	//we can append the right sub tree to the left right most node. then set the left sub tree as the right sub tree
    public void flatten(TreeNode root) {
		TreeNode p=root;
		while(p!=null){
			TreeNode leftright=p.left;
			while(leftright!=null&&leftright.right!=null)
				leftright=leftright.right;
			if(leftright==null){
				p=p.right;
				continue;
			}
			leftright.right=p.right;
			p.right=p.left;
			p.left=null;
			p=p.right;
		}
    }
}