public class Solution {
    public int removeDuplicates(int[] nums) {
		//to test the corner case is a good habit
		if(nums==null||nums.length==0) return 0;
        int writeindex = 1;
		int count=1;
		// we will reach the first element, so we should ensure it exists!
		int preint = nums[0];
		for(int readindex=1;readindex<nums.length;readindex++){
			if(preint == nums[readindex]){
				count++;
				if(count<=2){
					nums[writeindex]=nums[readindex];
					writeindex++;
				}else{
					
				}
			}else{
				count=1;
				preint = nums[readindex];
				nums[writeindex]=nums[readindex];
				writeindex++;
			}
		}
		return writeindex;
    }
}