
public class Solution {
    public int[][] generateMatrix(int n) {
        int [][] matrix =new int[n][n];
		int startrow=0;
		int endrow=n-1;
		int startcol=0;
		int endcol=n-1;
		int click=1;
		while(true){
			//from left to right
			for(int i=startcol;i<=endcol;i++){
				matrix[startrow][i]=click;
				click++;
			}
			startrow++;
			if(startrow>endrow) break;
			//from up to down
			for(int i=startrow;i<=endrow;i++){
				matrix[i][endcol]=click;
				click++;
			}
			endcol--;
			if(endcol<startcol)break;
			//from right to left
			for(int i=endcol;i>=startcol;i--){
				matrix[endrow][i]=click;
				click++;
			}
			endrow--;
			if(endrow<startrow) break;
			//from down to up
			for(int i=endrow;i>=startrow;i--){
				matrix[i][startcol]=click;
				click++;
			}
			startcol++;
			if(startcol>endcol)break;
		}
		return matrix;
    }
}