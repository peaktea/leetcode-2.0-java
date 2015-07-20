/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
		if(head==null) return null;
        ListNode current=head;
		ListNode p=head;
		ListNode pp=null;
		ListNode pre=null;
		while(current!=null){
			boolean duplcated = false;
			if(pre!=null){
				if(pre.val==current.val) duplcated = true;
			}
			if(!duplcated){
				p.val=current.val;
				pp=p;
				p=p.next;
			}
			pre=current;
			current=current.next;
		}
		pp.next=null;
		return head;
    }
}