public class Solution {
	//should return the next start
	int sortonecolor(int []nums,int target,int start,int end){
		if(start>=end){
			return start;
		}
		int left  =start;
		int right =end;
		while(left<right){
			while(left<right&&nums[left]==target) left++;
			while(right>left&&nums[right]!=target) right--;
			if(left>right){
				int tmp=nums[left];
				nums[left]=nums[right];
				nums[right]=tmp;
			}
		}
		int nextindex=end+1;
		for(int i=start;i<=end;i++){
			if(nums[i]!=target){
				nextindex=i;
				break;
			}
		}
		return nextindex;
	}
    public void sortColors(int[] nums) {
        int start = sortonecolor(nums,  0,    0,nums.length-1);
		start =     sortonecolor(nums,  1,start,nums.length-1);
		//start = sortonecolor(nums,2,start,nums.length-1);
    }
}