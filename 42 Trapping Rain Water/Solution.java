import java.util.*;

public class Solution {
    public int trap(int[] height) {
         //find the most height on the left
		int maxheight=0;
		int [] maxheightleft  = new int[height.length];
		for(int i=0;i<height.length;i++){
			maxheightleft[i]=maxheight;
			maxheight=maxheight>height[i]? maxheight:height[i];
		}
		//find the most height on the right
		maxheight=0;
		int [] maxheightright = new int[height.length];
		for(int i=height.length-1;i>=0;i--){
			maxheightright[i]=maxheight;
			maxheight=maxheight>height[i]?maxheight:height[i];
		}
		int watersum=0;
		for(int i=0;i<height.length;i++){
			int water=Math.min(maxheightright[i],maxheightleft[i])-height[i];
			if(water>0)
				watersum+=water;
		}
		return watersum;
    }
}