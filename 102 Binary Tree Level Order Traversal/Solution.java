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
	private void dp(List<List<Integer>> lists, TreeNode root,int level){
		if(root==null) return;
		if(level>=lists.size()){
			List<Integer> listone = new LinkedList<Integer>();
			lists.add(listone);
		}
		List<Integer> listone=lists.get(level);
		listone.add(root.val);
		dp(lists,root.left,level+1);
		dp(lists,root.right,level+1);
	}
	
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
		if(root==null) return lists;
		dp(lists,root,0);
		return lists;
    }
}