/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/
public class Solution {
    public int removeElement(int[] nums, int val) {
        int writeindex=-1;
		int num=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=val){
				num++;
				if(writeindex!=-1){
					nums[writeindex]=nums[i];
					writeindex++;
				}else{
						
				}
			}else{
				if(writeindex==-1){
					writeindex=i;
				}else{
					
				}
			}
		}
		return num;
    }
}