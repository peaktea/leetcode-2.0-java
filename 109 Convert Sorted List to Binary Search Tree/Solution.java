/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
	ListNode head=null;
	private TreeNode createTree(int start,int end){
		if(start>end) return null;
		int mid=(start+end)/2;
		TreeNode left = createTree(start,mid-1);
		TreeNode root = new TreeNode(head.val);
		head=head.next;
		TreeNode right= createTree(mid+1,end);
		root.left=left;
		root.right=right;
		return root;
	}
    public TreeNode sortedListToBST(ListNode h) {
		if(h==null) return null;
        int count=0;
		ListNode tmp=h;
		while(tmp!=null){count++;tmp=tmp.next;}
		return createTree(0,count-1);
    }
}