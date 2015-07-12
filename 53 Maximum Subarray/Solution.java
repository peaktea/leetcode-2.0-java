public class Solution {
    public int maxSubArray(int[] nums) {
        int [] endsum = new int[nums.length];
		endsum[0]=nums[0];
		int largestsum=nums[0];
		for(int i=1;i<nums.length;i++){
			if(endsum[i-1]>0){
				endsum[i]+=endsum[i-1]+nums[i];
			}
			else{
				endsum[i]=nums[i];
			}
			largestsum=largestsum>endsum[i]?largestsum:endsum[i];
		}
		return largestsum;
    }
}