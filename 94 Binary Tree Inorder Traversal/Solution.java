/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		List<Integer> list = new LinkedList<Integer>();
		while(true){
			//the stop condition
			if(current==null&&stack.isEmpty()){
				break;
			}
			//travel to the left most node
			while(current!=null){
				stack.push(current);
				current=current.left;
			}
			//pop the left most node, and visit it
			TreeNode head=stack.pop();
			list.add(head.val);
			//the travel path switch to the right child of the previous visited node
			current=head.right;
		}
		return list;
    }
}