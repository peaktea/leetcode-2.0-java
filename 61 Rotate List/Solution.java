/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /*
 此题的题意是把List向右移位k位。
 使用了两个指针，首先
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
		if(head==null||k==0){return head;}
        //count list length
		ListNode tmp=head;
		int sumnumber=1;
		while(tmp.next!=null){
			sumnumber++;
			tmp=tmp.next;
		}
		k=k%sumnumber;
		//move the first pointer to the k+1th place (k=1,2,3,...,)
		//why? if we move the [1,k+1] to the end, end the first index is just the 
		//last element in the new array
		//1 2 3 4 5 6
		//[     ]
		//begin move
		//1 2 3 4 5 6
		//    [     ]
		//3 is just the new last element
		
		tmp=head;
		int index=0;
		while(index<k&&tmp!=null){
			tmp=tmp.next;
			index++;
		}
		//must have the second half
		ListNode head1=head;
		while(tmp.next!=null){
			tmp=tmp.next;
			head1=head1.next;
		}
		//rotate the list
		tmp.next=head;
		head=head1.next;
		head1.next=null;
		return head;
    }
}