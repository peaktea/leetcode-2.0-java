/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4]. 
*/

public class Solution {
	public int searchLeftMost(int []nums,int target){
		int left=0;
		int right=nums.length-1;
		while(left<=right){
			int half=(left+right)/2;
			//because we want to locate the left most end, so when mid one is less than target, the left end should be updated to half+1,
			//the left end will approach the left most end. 
			if(nums[half]<target){
				left=half+1;
			}else{// when the mid one is larger or equal to the target, the right end should be updated to half - 1.
				// if larger, no problem, the new right end value will still larger or equal to the target
				// if equal, for example 1 2 3 4 4 4 5, will become 1 2 3 ,but the left index will increase to 4.
				// if equal, for example 1 2 4 4 4 4 5, will become 1 2 4 , the left end does not lose
				right=half-1;
			}
		}
		// very good corner case when the test data is [4] 9, in this case  the left index will be 1
		if(left<nums.length&&nums[left]==target) return left;
		return -1;
	}
	public int searchRightMost(int [] nums,int target){
		int left=0;
		int right=nums.length-1;
		while(left<=right){
			int half=(left+right)/2;
			//we want to locate the right end index, when mid value is larger than target, right = half- 1 will approach the right most end
			if(nums[half] > target){
				right = half-1;
			}else{
			//if less than target, left = half+1
			// if equal, for example, 1 2 3 will become 3, then become 2
			//if equal , 1 2 2 2 3, become 2 3, the right end does not lose
				left=half+1;
			}
		}
		//very good corner case when the test data is [5] 9, in this case the right index may be less than 0.
		if(right>=0&&nums[right]==target) return right;
		return -1;
	}
    public int[] searchRange(int[] nums, int target) {
        int [] re= new int[2];
		int leftend=searchLeftMost(nums,target);
		int rightend=searchRightMost(nums,target);
		re[0]= leftend;
		re[1]=rightend;
		return re;
    }
}