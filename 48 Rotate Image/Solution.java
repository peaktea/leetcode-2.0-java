public class Solution {
    public void rotate(int[][] matrix) {
        //flip up-down
		for(int i=0;i<matrix.length/2;i++){//for each row
			int dualrowindex=matrix.length-i-1;
			for(int j=0;j<matrix[0].length;j++){
				int tmp=matrix[i][j];
				matrix[i][j]=matrix[dualrowindex][j];
				matrix[dualrowindex][j]=tmp;
			}
		}
		//flip principal diagonal
		for(int i=0;i<matrix.length;i++){
			for(int j=i+1;j<matrix.length;j++){
				int tmp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=tmp;
			}
		}
    }
}