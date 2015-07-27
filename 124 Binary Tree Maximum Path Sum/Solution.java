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
	int maxsum=0;
	public int DF(TreeNode root){
		if(root==null) return 0;
		int leftmost = DF(root.left);
		int rightmost = DF(root.right);
		//������Ԫ�����Ҫ�ŵ����ŵ��У�����ȷ���ȼ�����������
		int maxthis=root.val+(leftmost>0?leftmost:0)+(rightmost>0?rightmost:0);
		maxsum=maxsum>maxthis?maxsum:maxthis;
		int subsum= Math.max(leftmost,rightmost);;
		return root.val+(subsum>0?subsum:0);
	}
    public int maxPathSum(TreeNode root) {
        maxsum=Integer.MIN_VALUE;
		DF(root);
		return maxsum;
    }
}