public class Solution {
    public int uniquePaths(int m, int n) {
        int [][] numbers = new int[m][n];
		numbers[0][0]=1;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i==0&&j==0) continue;
				else{
					//up
					if(i-1>=0)
						numbers[i][j]+=numbers[i-1][j];
					//down
					if(j-1>=0)
						numbers[i][j]+=numbers[i][j-1];
				}
			}
		}
		return numbers[m-1][n-1];
    }
}