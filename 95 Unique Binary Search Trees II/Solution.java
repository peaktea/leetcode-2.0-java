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
	private List<TreeNode> createTree(int start,int end){
		List<TreeNode> list = new LinkedList<TreeNode>();
		if(start>end){
			list.add(null);
			return list;
		}
		for(int i=start;i<=end;i++){
			List<TreeNode> leftTree = createTree(start,i-1);
			List<TreeNode> rightTree = createTree(i+1,end);
			for(int j=0;j<leftTree.size();j++){
				for(int k=0;k<rightTree.size();k++){
					TreeNode root =new TreeNode(i);
					root.left=leftTree.get(j);
					root.right=rightTree.get(k);
					list.add(root);
				}
			}
		}
		return list;
	}
    public List<TreeNode> generateTrees(int n) {
        return createTree(1,n);
    }
}