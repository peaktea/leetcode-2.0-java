public class Solution {
    public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int mindiff=Integer.MAX_VALUE;
		int closestsum=0;
        for(int i=0;i<nums.length;i++){
			int num1=nums[i];
			if(i>0&&num1==nums[i-1]){
				continue;
			}
			for(int j=i+1;j<nums.length;j++){
				int num2=nums[j];
				if(j>i+1&&num2==nums[j-1]){
					continue;
				}
				for(int k=j+1;k<nums.length;k++){
					int num3=nums[k];
					if(k>j+1&&num3==nums[k-1]){
						continue;
					}
					int sum=num1+num2+num3;
					int diff=Math.abs(sum-target);
					if(diff<mindiff){
						mindiff=diff;
						closestsum=sum;
						//corner case
						if(diff==0) return sum;
					}
					//corner case pruning method
					if(sum>target){
						break;
					}
				}
			}
		}
		return closestsum;
    }
}