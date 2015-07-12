public class Solution {
    public boolean canJump(int[] nums) {
        int curmax=0;
		for(int i=0;i<nums.length;i++){
			if(curmax<i){
				return false;
			}
			curmax=Math.max(curmax,i+nums[i]);
		}
		return true;
    }
}