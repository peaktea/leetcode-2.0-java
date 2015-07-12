public class Solution {
	private void backtrack(List<List<Integer> > lists, List<Integer> list, int [] nums, int index){
		if(index==nums.length){
			List<Integer> l = new LinkedList<Integer>();
			l.addAll(list);
			lists.add(l);
			return;
		}
		for(int i=index;i<nums.length;i++){
			if(i!=index&&nums[i]==nums[index]){
				continue;
			}
			int tmp=nums[index];
			nums[index]=nums[i];
			nums[i]=tmp;
			list.add(nums[index]);
			backtrack(lists,list,nums,index+1);
			list.remove(list.size()-1);
			//here does not need to swap the two elements back here.
			//as the loop next, the element first different to the nums[index] is the one which is larger than the nums[index]
			//we should notice that, the order of the element, in the next recursion call, is also sorted.
			// 1 1 [2] 2 3 -> 2 1 1 2 [3] -> 3 1 1 2 2 
		}
		//here the swap above, the order of the sequence has been changed(3 1 1 2 2), we should sort them back. because the upper one need it is sorted.
		Arrays.sort(nums,index,nums.length);
	}
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
		List<List<Integer> > lists =new LinkedList<List<Integer> >();
		List<Integer> list = new LinkedList<Integer>();
		backtrack(lists,list,nums,0);
		return lists;
    }
}