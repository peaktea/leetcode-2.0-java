public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
		boolean flag=false;
		List<List<Integer> > res=new LinkedList<List<Integer> >();
		for(int i=0;i<nums.length;i++){
			if(flag) break;
			int num1=nums[i];
			if(i>0){
				if(num1==nums[i-1]){
					continue;
				}
			}
			for(int j=i+1;j<nums.length;j++){
				if(flag) break;
				int num2=nums[j];
				if(j>i+1){
					if(num2==nums[j-1]){
						continue;
					}
				}
				for(int k=j+1;k<nums.length;k++){
					int num3=nums[k];
					if(k>j+1){
						if(num3==nums[k-1]){
							continue;
						}
					}
					int sum = num1 + num2 + num3;
					/*
					the pruning method is wrong, such as -2,-1,0,1,2,3
					-2+2+3>0,how ever -1+0+1 is missed!!
					if(sum>0){
						flag=true;
						break;
					}
					*/
					if(sum==0){
						List<Integer> listone=new ArrayList<Integer>();
						listone.add(num1);
						listone.add(num2);
						listone.add(num3);
						res.add(listone);
					}
				}
			}
		}
		return res;
    }
}