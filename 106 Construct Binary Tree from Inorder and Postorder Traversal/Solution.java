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
	private TreeNode createTree(int [] inorder,int leftindex1, int rightindex1, int [] postorder,int leftindex2, int rightindex2){
		if(leftindex1>rightindex1||leftindex2>rightindex2) return null;
		TreeNode root = new TreeNode(postorder[rightindex2]);
		int midindex=leftindex1;
		for(;midindex<=rightindex1;midindex++){
			if(inorder[midindex]==postorder[rightindex2])break;
		}
		int leftsize = midindex-leftindex1;
		int rightsize = rightindex1-midindex;
		// take an example to locate the right segment and left segment right
		TreeNode leftnode = createTree(inorder,leftindex1,leftindex1+leftsize-1,postorder,leftindex2,leftindex2+leftsize-1);
		TreeNode rightnode = createTree(inorder,leftindex1+leftsize+1,rightindex1,postorder,leftindex2+leftsize,rightindex2-1);
		root.left=leftnode;
		root.right=rightnode;
		return root;
	}
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return createTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
}