public class Solution {
	boolean valid(char [][]board,int r,int c){
		int []col = new int[9];
		for(int i=0;i<9;i++){
			if(board[r][i]!='.'){
				if(col[board[r][i]-'1']>0) return false;
				col[board[r][i]-'1']++;
			}
		}
		//test matrix
		int rindex=r/3;
		int cindex=c/3;
		int []count=new int[9];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(board[rindex+i][cindex+j]!='.'){
					if(count[board[rindex+i][cindex+j]-'1']>0) return false;
					count[board[rindex+i][cindex+j]-'1']++;
				}
			}
		}
		return true;
	}
	int [] getvaluelist(char [][]board, int r){
		int []count = new int[9];
		int num=0;
		for(int i=0;i<9;i++){
			if(board[r][i]!='.'){
				count[board[r][i]-'1']=1;
				num++;
			}
		}
		int []values=new int[num];
		int index=0;
		for(int i=0;i<9;i++){
			if(count[i]==0) values[index++]=i;
		}
		return values;
	}
	public boolean dp(char [][]board,int r,int c){
		if(board[r][c]=='.'){
			
		}else{}
	}
    public void solveSudoku(char[][] board) {
        
    }
}