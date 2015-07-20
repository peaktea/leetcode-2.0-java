/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /*
 In the solution below, the algorithm does not change the pointers but changes the data 
 stored in it. 
 So the algorithm uses two pointers method here.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;
		ListNode pp=null;
		ListNode p=head;
		ListNode pre=null;
		while(current!=null){
			boolean duplicated = false;
			if(current!=head){
				if(current.val==pre.val) duplicated=true;
			}
			if(current.next!=null){
				if(current.val==current.next.val) duplicated=true;
			}
			if(duplicated==false){
				p.val=current.val;
				pp=p;
				p=p.next;
			}
			pre=current;
			current = current.next;
		}
		if(pp==null) return null;
		pp.next=null;
		return head;
    }
}