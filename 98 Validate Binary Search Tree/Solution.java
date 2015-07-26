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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);    
    }
	// the BST can be seen as a kind of partition of the array, from -infinity,+infinity
	// On each node, we can update the end point of the partition.
	// In the left part, the right most end is current point
	// In the right part, the left most end is updated to the current point value;
	// If there are null node, we regard it as legal.
    public boolean isValidBST(TreeNode p, double min, double max){
        if(p==null) 
            return true;
        if(p.val <= min || p.val >= max)
            return false;
        return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
    }
}