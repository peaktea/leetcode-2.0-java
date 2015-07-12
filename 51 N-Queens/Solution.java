public class Solution {
	private boolean validate(int [][]matrix, int row,int col){
		//validate the column
		for(int i=row;i>=0;i--){
			if(matrix[i][col]==1) return false;
		}
		//validate the principal diagonal
		int tmprow=row;
		int tmpcol=col;
		while(tmprow>=0&&tmpcol>=0){
			if(matrix[tmprow][tmpcol]==1) return false;
			tmprow--;
			tmpcol--;
		}
		//validate the vice principal diagonal
		tmprow=row;
		tmpcol=col;
		while(tmprow>=0&&tmpcol<matrix.length){
			if(matrix[tmprow][tmpcol]==1) return false;
			tmprow--;
			tmpcol++;
		}
		return true;
	}
	public void backtrack(List<List<String> > lists,int [][] matrix,int row){
		if(row==matrix.length){
			//store the result
			List<String> listone=new LinkedList<String>();
			for(int i=0;i<matrix.length;i++){//for each row
				StringBuffer rowone=new StringBuffer();;
				for(int j=0;j<matrix.length;j++){
					if(matrix[i][j]==0)
						rowone.append(".");
					else
						rowone.append("Q");
				}
				listone.add(rowone.toString());
			}
			lists.add(listone);
			return;
		}
		for(int i=0;i<matrix.length;i++){//for each column
			if(validate(matrix,row,i)){
				matrix[row][i]=1;
				backtrack(lists,matrix,row+1);
			}
			matrix[row][i]=0;
		}
	}
    public List<List<String>> solveNQueens(int n) {
        int [][]matrix=new int[n][n];
		List<List<String> > lists =new LinkedList<List<String> >();
		backtrack(lists,matrix,0);
		return lists;
    }
}