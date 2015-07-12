public class Solution {
    public int jump(int[] nums) {
        //greedy method
		int curmax=0;
		int jumpnum=0;
		int curreach=0;
		for(int i=0;i<nums.length;i++){
			if(curreach<i){
				jumpnum++;
				curreach=curmax;
			}
			curmax=Math.max(curmax,i+nums[i]);
		}
		return jumpnum;
    }
}