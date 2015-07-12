/*
 Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space. 
这里所说的缺失的第一个整数实际上是从1开始进行计数的，比如
-1,0,1,3少了2
1,2,3,4，7少了5
*/
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int pos=0;
		while(pos<nums.length){
			if(nums[pos]>0&&nums[pos]!=pos+1&&nums[pos]-1<nums.length&&nums[pos]!=nums[nums[pos]-1]){
				int tmp=nums[pos];
				// corner case here is we should store the changeindex first, because it will change as the nums[pos]
				//changed
				int changeindex= nums[pos]-1;
				nums[pos]=nums[changeindex];
				nums[changeindex]=tmp;
			}else{
				pos++;
				System.out.println("ss");
			}
			
		}
		for(int i=0;i<nums.length;i++){
			if(i+1!=nums[i])
				return i+1;
		}
		return nums.length+1;
    }
}