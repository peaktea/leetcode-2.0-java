/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
		if(head==null){
			return head;
		}
        ListNode dummy1= new ListNode(0);
		ListNode dummy2= new ListNode(0);
		ListNode head1 = dummy1,head2 = dummy2;
		ListNode current = head;
		while(current!=null){
			if(current.val<x){
				head1.next=current;
				head1=current;
			}else{
				head2.next=current;
				head2=current;
			}
			current=current.next;
		}
		if(dummy1.next==null)
			return dummy2.next;
		else{
			head1.next=dummy2.next;
			//this is a trick, if the head2.next pointer is not set to be null, then
			//there may be a loop here.
			//head2 may be not the last one, so the next pointer is pointer to a element to
			// former element,from former element can reach the head2 again, here is a
			//loop
			head2.next=null;
			return dummy1.next;
		}
    }
}