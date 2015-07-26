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
 local continuous
 preorder: 2 0 1 4 3
 inorder:  0 1 2 3 4
 2 is the root,
 preorder is break into 0 1 , 4 3
 inorder  is break into 0 1 , 3 4
 they are continuous,so we just need to know the segment size, to locate 
 the right segment and the left segment
 */
public class Solution {
	public TreeNode createTree(int []preorder, int leftindex1,int rightindex1, int [] inorder ,int leftindex2,int rightindex2){
		if(leftindex1>rightindex1||leftindex2>rightindex2) return null;
		TreeNode root = new TreeNode(preorder[leftindex1]);
		int midindex=leftindex2;
		for(;midindex<=rightindex2;midindex++){
			if(inorder[midindex]==preorder[leftindex1]) break;
		}
		int leftsize=midindex-leftindex2;
		int rightsize=rightindex2-midindex;
		TreeNode leftnode = createTree(preorder,leftindex1+1,leftindex1+leftsize,inorder,leftindex2,leftindex2+leftsize-1);
		TreeNode rightnode = createTree(preorder,leftindex1+leftsize+1,rightindex1,inorder,leftindex2+leftsize+1,rightindex2);
		root.left=leftnode;
		root.right=rightnode;
		return root;
	}
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = createTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
		return root;
    }
}