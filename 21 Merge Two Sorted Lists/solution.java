

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null||l2==null) return l1==null?l2:l1;
		ListNode head=null;
		ListNode prenode=null;
		while(l1!=null&&l2!=null){
			ListNode curnode=null;
			if(l1.val<l2.val){curnode=l1;l1=l1.next;}
			else{curnode=l2;l2=l2.next;}
			if(head==null){
				head=curnode;
				prenode=curnode;
			}else{
				prenode.next=curnode;
				prenode=curnode;
			}
		}
		if(l1!=null) prenode.next=l1;
		else prenode.next=l2;
		return head;
    }
}