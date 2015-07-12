/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers. 

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order). 

The replacement must be in-place, do not allocate extra memory. 

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 ¡ú 1,3,2
3,2,1 ¡ú 1,2,3
1,1,5 ¡ú 1,5,1

*/

public class Solution {
    public void nextPermutation(int[] nums) {
		//search for the first decrease order,from right to left-hand
		int i=nums.length-1;
		for(;i>0;i--){
			if(nums[i]>nums[i-1]){
				break;
			}
		}
		//if there is no decrease order, just return the increase order
		if(i==0){
			Arrays.sort(nums);
			return;
		}
		i--;
		int j=nums.length-1;
		for(;j>=0;j--){
			if(nums[j]>nums[i]){//get it here
				int tmp = nums[j];
				nums[j]=nums[i];
				nums[i]=tmp;
				break;
			}
		}
		//swap
		int begin=i+1;
		int end=nums.length-1;
		while(begin<end){//should focuse on how to swap, the two elements
			int tmp = nums[begin];
			nums[begin]=nums[end];
			nums[end]=tmp;
			begin++;
			end--;
		}
    }
}