public class Solution {
    public void sortColors(int[] nums) {
		int left=0;
		int right=nums.length-1;
		int i=left;
		for(;i<=right;){
			//swap to the left most
			if(nums[i]==0){
				int tmp = nums[i];
				nums[i]=nums[left];
				nums[left]=tmp;
				left++;
				i++;
				continue;
			}
			//swap to the right most
			else if(nums[i]==2){
				int tmp = nums[i];
				nums[i]=nums[right];
				nums[right]=tmp;
				right--;
				
				continue;
			}else{
			    i++;
			}
			//pay attention to the if else if else, �����Լ򵥵ı�Ϊif if if��
			//��Ϊǰ����ƽ�еĹ�ϵ�������жϵ�������һ���ģ�������Ǵ��еĶ��ϵ��
			//�ڵ�һ��if���п��ܻ�ı�ڶ���if���е��ж�����
		}
    }
}