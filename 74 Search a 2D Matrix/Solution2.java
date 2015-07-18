public class Solution {
    public void sortColors(int[] nums) {
		int left=0;
		int right=nums.length-1;
		int i=left;
		for(;i<=right;){
			//swap to the left most
			if(nums[i]==0){
				int tmp = nums[i];
				nums[i]=nums[left];
				nums[left]=tmp;
				left++;
				i++;
				continue;
			}
			//swap to the right most
			else if(nums[i]==2){
				int tmp = nums[i];
				nums[i]=nums[right];
				nums[right]=tmp;
				right--;
				
				continue;
			}else{
			    i++;
			}
			//pay attention to the if else if else, 不可以简单的变为if if if，
			//因为前者是平行的关系，他们判断的条件是一样的，后面的是穿行的额关系，
			//在第一个if当中可能会改变第二个if当中的判断条件
		}
    }
}