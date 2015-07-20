import java.util.*;

public class Solution {
	private int maxArea(int [] height){
		Vector<Integer> h = new Vector<Integer>();
		for(int i: height)
			h.add(i);
		h.add(0);
		Stack<Integer> stack = new Stack<Integer>();
		int i=0;
		int maxarea=0;
		while(i<h.size()){
			if(stack.isEmpty()||(h.get(i)>=h.get(stack.peek()))){
				stack.add(i++);
			}else{
				int index = stack.pop();
				int width = stack.isEmpty()?i:(i-stack.peek()-1);
				int tmparea = width*(h.get(index));
				maxarea=Math.max(tmparea,maxarea);
			}
		}
		return maxarea;
	}
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int [] height = new int[matrix[0].length];
		for(int j=0;j<height.length;j++){
			if(matrix[0][j]=='1')
				height[j]=1;
		}
		int maxarea=0;
		for(int i=0;i<matrix.length;i++){
			int tmparea=0;
			if(i==0){
				tmparea= maxArea(height);
			}else{
				for(int j=0;j<height.length;j++){
					if(matrix[i][j]=='0'){
						height[j]=0;
						continue;
					}
					int thisadd=1;
					if(height[j]==0){
						height[j]=thisadd;
					}else{
						height[j]=height[j]+thisadd;
					}
				}
				tmparea=maxArea(height);
			}
			maxarea = Math.max(tmparea,maxarea);
		}
		return maxarea;
    }
}