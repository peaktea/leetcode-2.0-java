import java.util.*;
/*
	we use a stack the track the increase sequence.
	such as 3 6 10, the increase block can be seen as the independent unit to compute
	the max area. Because first it has no relation with the former sequence. Such as 
	4 5 6 7 , 3
	before 7 is the increase sequence and the 3 is decrease.
	obviously, we can compute the max area from the begin index 4,5,6,7. They have
	no relation with 3.
	Another case:
	4 6 7 8 , 5
	we can compute the max area from index 6,7,8. However this does not work on 4, because 
	4<5. There may be more larger area.
	Here the height 8 can be seen as a block, the height after it is not available to
	the height before it which is less than it, so we can pop the height 6,7,8 to 
	compute the height here
*/
public class Solution {
    public int largestRectangleArea(int[] height) {
        Vector<Integer> h = new Vector<Integer>();
		for(int i: height)
			h.add(i);
		h.add(0);
		Stack<Integer> stack = new Stack<Integer>();
		int maxarea=0;
		int i=0;
		while(i<h.size()){
			if(stack.isEmpty()||(h.get(i)>=h.get(stack.peek()))){
				stack.push(i++);
			}
			else{
				int index = stack.pop();
				int width = stack.isEmpty()? i:(i-stack.peek()-1);
				int tmparea = height[index]*width;
				maxarea=Math.max(maxarea,tmparea);
			}
		}
		return maxarea;
    }
}