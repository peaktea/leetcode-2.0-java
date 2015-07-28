public class Solution {
	/*
		If we call the function Math.max(), and Math.min(), the time will exceeded!!!!
		The solution below is amazing!
	*/
	private int max(int a,int b){
		if(a>b) return a;
		else return b;
	}
	private int min(int a,int b){
		if(a<b) return a;
		else return b;
	}
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0) return 0;
		if(nums.length==1) return nums[0];
		int globalmax=nums[0];
		int localmax=nums[0];
		int localmin=nums[0];
		for(int i=1;i<nums.length;i++){
			int localmax_copy = localmax;
			int t = nums[i];
			localmax=max(max(t,localmax*t),localmin*t);
			localmin=min(min(t,localmax_copy*t),localmin*t);
			globalmax=max(globalmax,localmax);
		}
		return globalmax;
    }
}