/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode firsttail=null;
		for(int i=1;i<m;i++){
			if(i==1)firsttail=head;
			else{
				firsttail=firsttail.next;
			}
		}
		ListNode secondhead=firsttail!=null?firsttail.next:head;
		ListNode secondtail=secondhead;
		for(int i=1;i<(n-m+1);i++){
			secondtail=secondtail.next;
		}
		ListNode thirdhead=secondtail.next;
		//reverse second segment
		ListNode pre=null;
		ListNode tmp=secondhead;
		ListNode stopNode = secondtail.next;
		while(tmp!=stopNode){
			ListNode tlist=tmp.next;
			tmp.next=pre;
			pre=tmp;
			tmp=tlist;
		}
		if(firsttail==null){
			secondhead.next=thirdhead;
			head=secondtail;
		}else{
			firsttail.next=secondtail;
			secondhead.next=thirdhead;
		}
		return head;
    }
}