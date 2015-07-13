public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m=obstacleGrid.length;
		int n=obstacleGrid[0].length;
        int [][] numbers = new int[m][n];
		//two corner cases: the first place or the last place is not reachable
		if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1) return 0;
		numbers[0][0]=1;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				//up
				if(i-1>=0&&obstacleGrid[i-1][j]==0){
					numbers[i][j]+=numbers[i-1][j];
				}
				//left
				if(j-1>=0&&obstacleGrid[i][j-1]==0){
					numbers[i][j]+=numbers[i][j-1];
				}
			}
		}
		return numbers[m-1][n-1];
    }
}