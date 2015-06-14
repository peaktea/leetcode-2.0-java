/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode reverse(ListNode node){
		ListNode prenode=null;
		ListNode curnode=node;
		while(curnode!=null){
			ListNode next=curnode.next;
			curnode.next=prenode;
			prenode=curnode;
			curnode=next;
		}
		return prenode;
	}
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head=reverse(head);
		if(n==1){
			head=head.next;
			head=reverse(head);
			return head;
		}else{
			ListNode prenode=null;
			for(int i=0;i<n-1;i++){
				if(prenode==null) 
					prenode=head;
				else
					prenode=prenode.next;
			}
			ListNode deletenode=prenode.next;
			prenode.next=deletenode.next;
			head=reverse(head);
			return head;
		}
    }
}