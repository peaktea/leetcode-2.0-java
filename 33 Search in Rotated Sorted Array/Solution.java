/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

*/

public class Solution {
    public int search(int[] nums, int target) {
        int left=0;
		int right=nums.length-1;
		while(left<=right){
			int half=(left+right)/2;
			if(nums[half]==target) return half;
			if(nums[half] >=nums[left]){//half may be equal to left, when there is only one two elements
				if(target>=nums[left]&&target<nums[half]){
					right=half-1;
				}else{
					left=left+1;
				}
			}else {
				if(target<=nums[right]&&target>nums[half]){//
					left=left+1;
				}else{
					right=right-1;
				}
			}
		}
		return -1;
    }
}