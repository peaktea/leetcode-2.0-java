public class Solution {
    public int maxArea(int[] height) {
        int maxwater=-1;
		int left=0;
		int right=height.length-1;
		while(left<right){
			int h=height[left]<height[right]?height[left]:height[right];
			int tmpwater=h*(right-left);
			maxwater=maxwater>tmpwater?maxwater:tmpwater;
			if(height[right]>height[left]) left++;
			else right--;
		}
		return maxwater;
    }
}