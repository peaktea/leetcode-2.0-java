import java.util.*;

public class Solution {
	private void dp(Vector<Integer> num, Vector<Integer> count,int index, int target, int tmpsum, 
	List<Integer> tmplist,List<List<Integer> > lists){
		if(tmpsum==target){
			List<Integer> l = new LinkedList<Integer>();
			l.addAll(tmplist);
			lists.add(l);
			return;
		}
		if(index==num.size()||tmpsum>target) return;
		int tmpcount=count.get(index);
		int number=num.get(index);
		for(int i=0;i<tmpcount;i++){
			tmplist.add(number);
			dp(num,count,index+1,target,tmpsum+(i+1)*number,tmplist,lists);
		}
		//because there is only one tmplist, when all the cases which contain number 
		//has been tried, we try the one which ignore it.
		for(int i=0;i<tmpcount;i++){
			tmplist.remove(tmplist.size()-1);
		}
		dp(num,count,index+1,target,tmpsum,tmplist,lists);
	}
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
		/////the code below is to statistic the unique numbers and the number 
		/////of each of them
		Vector<Integer> num =new Vector<Integer>();
		Vector<Integer> count =new Vector<Integer>();
		int pre=candidates[0];
		int tmpcount=1;
		for(int i=1;i<candidates.length;i++){
			if(candidates[i]==pre){
				tmpcount++;
			}else{
				num.add(pre);
				count.add(tmpcount);
				pre=candidates[i];
				tmpcount=1;
			}
		}
		num.add(pre);
		count.add(tmpcount);
		//to call the method above
		List<Integer> tmplist =new LinkedList<Integer>();
		List<List<Integer> > lists =new LinkedList<List<Integer> >();
		dp(num,count,0,target,0,tmplist,lists);
		return lists;
    }
}