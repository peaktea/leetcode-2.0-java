/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 import java.util.*;
public class Solution {
	private Vector<ListNode> getTuples(ListNode head,int k){
		Vector<ListNode> v = new Vector<ListNode>();
		ListNode prenode=null;
		ListNode curnode=head;
		for(int i=0;i<k&&curnode!=null;i++){
			ListNode next = curnode.next;
			curnode.next=prenode;
			prenode=curnode;
			curnode=next;
		}
		ListNode next=curnode;
		Vector<ListNode> res = new Vector<ListNode>();
		res.add(prenode);
		res.add(head);
		res.add(next);
		return res;
	}
    public ListNode swapPairs(ListNode head) {
        ListNode newhead = null;
		ListNode tmptail = null;
		while(true){
			Vector<ListNode> res = getTuples(head,2);
			ListNode h=res.get(0);
			ListNode t=res.get(1);
			ListNode n=res.get(2);
			if(newhead==null){
				newhead=h;
				tmptail=t;
				head=n;
			}else{
				tmptail.next=h;
				tmptail=t;
				head=n;
			}
			if(n==null) break;
		}
		return newhead;
    }
}