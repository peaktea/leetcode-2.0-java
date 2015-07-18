public class Solution {
	private void backtree(List<List<Integer> > lists,List<Integer> tmplist,
		int start,int end,int []nums){
		//at each reach node, we add the tmplist to the lists result
		List<Integer> l=new LinkedList<Integer>();
		l.addAll(tmplist);
		lists.add(l);
		for(int i=start;i<=end;i++){
			tmplist.add(nums[i]);
			backtree(lists,tmplist,i+1,end,nums);
			tmplist.remove(tmplist.size()-1);
		}
	}
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
		List<List<Integer> > lists =new LinkedList<List<Integer> >();
		List<Integer> tmplist =new LinkedList<Integer>();
		backtree(lists,tmplist,0,nums.length-1,nums);
		return lists;
    }
}