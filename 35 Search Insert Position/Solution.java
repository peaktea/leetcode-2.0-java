/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 ¡ú 2
[1,3,5,6], 2 ¡ú 1
[1,3,5,6], 7 ¡ú 4
[1,3,5,6], 0 ¡ú 0 
*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0;
		int right=nums.length-1;
		while(left<=right){
			int mid=(left+right)/2;
			if(nums[mid]<target){
				left=mid+1;
			}else if(nums[mid]>target){
				right=mid-1;
			}else{
				return mid;
			}
		}
		// we can assume some examples, then we can summarize which index slot is the one will be inserted.
		if(right<0) return 0;
		if(left>=nums.length) return nums.length;
		return left;
    }
}