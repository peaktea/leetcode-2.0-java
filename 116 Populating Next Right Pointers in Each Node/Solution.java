/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 /*
 when one level is finished, we will get a head of that level. This head can be seen as a travel cue for that level.
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head=root;
		while(head!=null){
			TreeLinkNode tmphead=head;
			head=null;
			TreeLinkNode pre=null;
			while(tmphead!=null){
				if(tmphead.left!=null){
					if(head==null){
						pre=head=tmphead.left;
					}
					else{
						pre.next=tmphead.left;
						pre=tmphead.left;
					}
				}
				if(tmphead.right!=null){
					if(head==null){
						pre=head=tmphead.right;
					}else{
						pre.next=tmphead.right;
						pre=tmphead.right;
					}
				}
				tmphead=tmphead.next;
			}
		}
    }
}