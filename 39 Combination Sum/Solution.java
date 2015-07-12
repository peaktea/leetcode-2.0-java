/*
void comb(vector<int> candidates, int index, int sum, int target, vector<vector<int>> &res, vector<int> &path)
    {
    	if(sum>target)return;
		if(sum==target){res.push_back(path);return;}
		for(int i= index; i<candidates.size();i++)
		{
			path.push_back(candidates[i]);
			comb(candidates,i,sum+candidates[i],target,res,path);
			path.pop_back();
		}
	}
	vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
        // Note: The Solution object is instantiated only once.
        sort(candidates.begin(),candidates.end());
		vector<vector<int>> res;
		vector<int> path;
		comb(candidates,0,0,target,res,path);
		return res;
    }
	上面的代码由于没有对相同数字可能出现的次数进行计数，真正的技术问题转移到了递归调用到中，
	每增加一个数字，就会导致递归调用多一个层次。从造成一个问题，可能会递归调用的stack 
	over flow
*/

import java.util.*;

public class Solution {
	public void dp(int[] candidates, int index, int target,List<List<Integer>> lists,
	List<Integer> tmplist, int tmpsum){
		if(tmpsum==target) {
			List<Integer> l = new LinkedList<Integer>();
			l.addAll(tmplist);
			lists.add(l);
			return;
		}
		if(tmpsum>target||index==candidates.length) return;
		int maxnum=(target-tmpsum)/candidates[index];
		for(int i=0;i<maxnum;i++){
			tmplist.add(candidates[index]);
			dp(candidates,index+1,target,lists,tmplist,tmpsum+candidates[index]*(i+1));
		}
		//not consider it any more
		for(int i=0;i<maxnum;i++){
			tmplist.remove(tmplist.size()-1);
		}
		dp(candidates,index+1,target,lists,tmplist,tmpsum);
	}
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
		// if the candidates are not sorted ,then we need to sort each conditioned 
		// tmplist. Because it need the tmplist should be sorted.
		Arrays.sort(candidates);
        List<List<Integer>> lists =new LinkedList<List<Integer>> ();
		List<Integer> tmplist = new LinkedList<Integer>();
		dp(candidates,0,target,lists,tmplist,0);
		return lists;
    }
}