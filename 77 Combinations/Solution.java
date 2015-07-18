public class Solution {
	public void backtree(List<List<Integer>> lists,List<Integer> tmplist, 
		int start,int end,int k){
		if(tmplist.size()==k){
			List<Integer> l =new LinkedList<Integer>();
			l.addAll(tmplist);
			lists.add(l);
		}
		for(int i=start;i<=end;i++){
			tmplist.add(i);
			backtree(lists,tmplist,i+1,end,k);
			tmplist.remove(tmplist.size()-1);
		}
	}
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new LinkedList<List<Integer> >();
		List<Integer> tmplist =new LinkedList<Integer>();
		backtree(lists,tmplist,1,n,k);
		return lists;
    }
}