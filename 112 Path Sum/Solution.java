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
	boolean flag=false;
	public void getsum(TreeNode root,int sum, int tmpsum){
		if(flag) return;
		if(root==null) return;
		tmpsum+=root.val;
		if(root.left==null&&root.right==null&&tmpsum==sum){
			flag=true;
			return;
		}
		getsum(root.left,sum,tmpsum);
		if(flag) return;
		getsum(root.right,sum,tmpsum);
		return;
	}
    public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null){// the corner case is define by the author of the problem, if the root is null ,then return false regardless of the sum number
			return false;
		}
        flag=false;
		getsum(root,sum,0);
		return flag;
    }
}