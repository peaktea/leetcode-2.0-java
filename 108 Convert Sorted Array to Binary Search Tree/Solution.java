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
	private TreeNode createTree(int[]nums,int left,int right){
		if(left>right) return null;
		int mid=(right+left)/2;
		TreeNode root = new TreeNode(nums[mid]);
		TreeNode leftnode= createTree(nums,left,mid-1);
		TreeNode rightnode= createTree(nums,mid+1,right);
		root.left=leftnode;
		root.right=rightnode;
		return root;
	}
    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums,0,nums.length-1);
    }
}