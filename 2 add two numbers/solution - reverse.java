public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
	private ListNode reverse(ListNode node){
		ListNode pre=null;
		ListNode cur=node;
		while(cur!=null){
			ListNode next=cur.next;
			cur.next=pre;
			pre=cur;
			cur=next;
		}
		return pre;
	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l2==null||l1==null)
			return l1==null? l2:l1;
		ListNode h1=reverse(l1);
		ListNode h2=reverse(l2);
		ListNode head1=h1;
		ListNode head2=h2;
		
		int pre=0;
		ListNode newhead=null;
		ListNode prenode=null;
		while(head1!=null&&head2!=null){
			int sum=pre+head1.val+head2.val;
			ListNode tmp = new ListNode(sum%10);
			pre=sum/10;
			if(newhead==null){
				newhead=tmp;
				prenode=tmp;
			}else{
				prenode.next=tmp;
				prenode=tmp;
			}
			head1=head1.next;
			head2=head2.next;
		}
		ListNode leftnode=null;
		if(head1!=null) leftnode=head1;
		else leftnode=head2;
		if(leftnode!=null){
			while(leftnode!=null){
				int sum = pre+leftnode.val;
				ListNode tmp =new ListNode(sum%10);
				pre=sum/10;
				prenode.next=tmp;
				prenode=tmp;
			}
			leftnode=leftnode.next;
		}
		if(pre!=0){
			ListNode tmp=new ListNode(pre);
			prenode.next=tmp;
			tmp.next=null;
		}
		reverse(l1);
		reverse(l2);
		return newhead;
    }
}