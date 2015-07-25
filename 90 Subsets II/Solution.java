import java.util.*;

public class Solution {
	//using the same method as no duplicate version, we just list the start point here
	private void backtrack(List<List<Integer>> lists,List<Integer> listone,int digitindex,
		Vector<Integer>alldigits,Vector<Integer> allcounts){
		//only reach the last index, we can store the state into the lists, 
		//the temporal states before reach the last index may be same
		//for example 1 1 1 
		// store [] 
		// 1 1 1 store  1 1 1
		// 1 1 1 remove  , backtrack 1 1 1 
		if(digitindex==alldigits.size()){
			List<Integer> l=new LinkedList<Integer>();
			l.addAll(listone);
			lists.add(l);
			return;
		}
		int count=allcounts.get(digitindex);
		int digit=alldigits.get(digitindex);
		for(int i=0;i<count;i++){
			listone.add(digit);
			backtrack(lists,listone,digitindex+1,alldigits,allcounts);
		}
		for(int i=0;i<count;i++){
			listone.remove(listone.size()-1);
		}
		backtrack(lists,listone,digitindex+1,alldigits,allcounts);
	}
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
		Vector<Integer> alldigits = new Vector<Integer>();
		Vector<Integer> allcounts = new Vector<Integer>();
		int count=0;
		for(int i=0;i<nums.length;i++){
			if(i==0){
				alldigits.add(nums[i]);
				count=1;
				continue;
			}
			if(nums[i]==nums[i-1]){
				count++;
			}else{
				allcounts.add(count);
				alldigits.add(nums[i]);
				count=1;
			}
		}
		allcounts.add(count);
		List<List<Integer> > lists =new LinkedList<List<Integer> >();
		List<Integer> listone = new LinkedList<Integer>();
		backtrack(lists,listone,0,alldigits,allcounts);
		return lists;
    }
}