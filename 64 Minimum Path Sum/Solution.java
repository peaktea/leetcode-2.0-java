public class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
		int n=grid[0].length;
		int [][] tmpsum = new int[m][n];
		tmpsum[0][0]=grid[0][0];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i==0&&j==0) continue;
				//up
				// pay attention to Integer.MAX_VALUE , not Integer.MAX_VALUES
				
				int upsum=Integer.MAX_VALUE;
				if(i-1>=0){
					upsum=tmpsum[i-1][j];
				}
				int leftsum=Integer.MAX_VALUE;
				if(j-1>=0){
					leftsum=tmpsum[i][j-1];
				}
				tmpsum[i][j]=Math.min(upsum,leftsum)+grid[i][j];
			}
		}
		return tmpsum[m-1][n-1];
    }
}