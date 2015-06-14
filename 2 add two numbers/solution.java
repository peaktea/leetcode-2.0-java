public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null||l2==null)
			return l1==null?l2:l1;
		int pre = 0;
		ListNode newhead=null;
		ListNode prenode=null;
		while(l1!=null && l2!=null){
			int sum = pre + l1.val+ l2.val;
			ListNode tmp = new ListNode(sum%10);
			pre=sum/10;
			if(newhead==null){
				newhead=tmp;
				prenode=tmp;
			}else{
				prenode.next=tmp;
				prenode=tmp;
			}
			l1=l1.next;
			l2=l2.next;
		}
		ListNode leftnode= null;
		if(l1==null)leftnode=l2;
		else leftnode=l1;
		while(leftnode!=null){
			int sum=pre+leftnode.val;
			ListNode tmp = new ListNode(sum%10);
			prenode.next=tmp;
			prenode=tmp;
			pre=sum/10;
			leftnode=leftnode.next;
		}
		if(pre!=0){
			ListNode tmp =new ListNode(pre);
			prenode.next=tmp;
			tmp.next=null;
		}
		return newhead;
	}
}