/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.*;
 /*
class MyCompare implements Comparator{
	public int compare(Object o1, Object o2){
		ListNode n1 = (ListNode)o1;
		ListNode n2 = (ListNode)o2;
		if(n1.val < v2.val){
			return 1;
		}else if(n1.val==n2.val){
			return 0;
		}else{
			return -1;
		}
	}
}
*/
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
		if(lists==null||lists.length==0) return null;
		Comparator<ListNode> mc = new Comparator<ListNode>(){
			public int compare(ListNode n1, ListNode n2){
				//should pay attention to the return value below
				if(n1.val < n2.val){
					return -1;
				}else if(n1.val==n2.val){
					return 0;
				}else{
					return 1;
				}
			}
		};
        Queue queue = new PriorityQueue(lists.length,mc);
		for(int i=0;i<lists.length;i++){
			//there may be the contents in the lists is null, this is a corner case
			if(lists[i]!=null)
				queue.add(lists[i]);
		}
		ListNode head=null;
		ListNode prenode=null;
		while(!queue.isEmpty()){
			ListNode top = (ListNode)queue.poll();
			ListNode next =  top.next;
			top.next=null;
			if(head==null){
				head=top;
				prenode=top;
			}else{
				prenode.next=top;
				prenode=top;
			}
			if(next!=null){
				queue.add(next);
			}
		}
		return head;
    }
}