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
		int i=0;
		for(;i<k&&curnode!=null;i++){
			ListNode next = curnode.next;
			curnode.next=prenode;
			prenode=curnode;
			curnode=next;
		}
		Vector<ListNode> res = new Vector<ListNode>();
		if(i!=k){//not need to reverse, then should revers back
			ListNode tmpnode=prenode;
			ListNode pretmpnode=null;
			while(true){
				ListNode ttmpnext = tmpnode.next;
				tmpnode.next =  pretmpnode;
				pretmpnode=tmpnode;
				tmpnode=ttmpnext;
				if(tmpnode==null) break;
			}
			res.add(head);
			res.add(prenode);
			res.add(null);
		}else{
			ListNode next=curnode;
			res.add(prenode);
			res.add(head);
			res.add(next);
		}
		
		return res;
	}
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return null;
        ListNode newhead = null;
		ListNode tmptail = null;
		while(true){
			Vector<ListNode> res = getTuples(head,k);
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