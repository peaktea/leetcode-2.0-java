/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        int readindex=0;
		int writeindex=0;
		int prenum=0;
		for(;readindex<nums.length;readindex++){
			if(readindex>0){
				if(nums[readindex]==prenum){
					//no write,
				}
				else{
					nums[writeindex]=nums[readindex];
					writeindex++;
				}
			}else{
				writeindex++;
			}
			prenum=nums[readindex];
		}
		return writeindex;
    }
}