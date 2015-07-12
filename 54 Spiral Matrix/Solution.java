public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<Integer>();
		if(matrix==null||matrix.length==0){
			return list;
		}
        int startrow=0;
		int endrow=matrix.length-1;
		int startcol=0;
		int endcol=matrix[0].length-1;
		//when finish read one edge, the xy edge should be updated also
		while(true){
			//from left to right
			for(int i=startcol;i<=endcol;i++){
				list.add(matrix[startrow][i]);
			}
			startrow++;
			if(startrow>endrow) break;
			//for up to down
			for(int i=startrow;i<=endrow;i++){
				list.add(matrix[i][endcol]);
			}
			endcol--;
			if(endcol<startcol)break;
			//from right to left
			for(int i=endcol;i>=startcol;i--){
				list.add(matrix[endrow][i]);
			}
			endrow--;
			if(endrow<startrow) break;
			//from down to up
			for(int i=endrow;i>=startrow;i--){
				list.add(matrix[i][startcol]);
			}
			startcol++;
			if(startcol>endcol) break;
		}
		return list;
    }
}