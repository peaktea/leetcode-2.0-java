import java.util.*;

public class Solution {
	private void backtrack(List<List<Integer> > lists, int []nums, int index){
		if(index==nums.length){
			List<Integer> tl=new LinkedList<Integer>();
			for(int element: nums){
				tl.add(element);
			}
			lists.add(tl);
		}
		for(int i=index;i<nums.length;i++){
			//at each index, change the first element at that index with each the following element values.
			int tmp=nums[i];
			nums[i]=nums[index];
			nums[index]=tmp;
			backtrack(lists,nums,index+1);
			tmp=nums[i];
			nums[i]=nums[index];
			nums[index]=tmp;
		}
	}
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer> > lists = new LinkedList<List<Integer> >();
		backtrack(lists,nums,0);
		return lists;
    }
}