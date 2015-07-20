public class Solution {
	//  1 2 3 4 5 6 7
	//->4 5 6 7 1 2 3
	
    public boolean search(int[] nums, int target) {
        int left=0;
		int right=nums.length-1;
		while(left<=right){
			int mid = (left+right)/2;
			if(nums[mid]==target){
				return true;
			}
			if(nums[mid]>nums[left]){
				if(nums[mid]>target&&nums[left]<=target){
					right=mid-1;
				}else{
					left=mid+1;
				}
			}else if(nums[mid]<nums[left]){
				if(nums[mid]<target&&nums[right]>=target){
					left=mid+1;
				}else{
					right=mid-1;
				}
			}else{
				left++;
			}
		}
		return false;
    }
}