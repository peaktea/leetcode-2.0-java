public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer> > listall = new LinkedList<List<Integer> >();
        for(int i=0;i<nums.length;i++){
			int num1=nums[i];
			if(i>0&&num1==nums[i-1]) continue;
			for(int j=i+1;j<nums.length;j++){
				int num2=nums[j];
				if(j>i+1&&num2==nums[j-1]) continue;
				for(int k=j+1;k<nums.length;k++){
					int num3=nums[k];
					if(k>j+1&&num3==nums[k-1]) continue;
					for(int m=k+1;m<nums.length;m++){
						int num4=nums[m];
						if(m>k+1&&num4==nums[m-1]) continue;
						int sum=num1+num2+num3+num4;
						if(sum==target){
							List<Integer> listone = new LinkedList<Integer>();
							listone.add(num1);
							listone.add(num2);
							listone.add(num3);
							listone.add(num4);
							listall.add(listone);
						}
						if(sum>target)
							break;
					}
				}
			}
		}
		return listall;
    }
}