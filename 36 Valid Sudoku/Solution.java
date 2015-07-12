/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/

/*
 this problem is naive, if there is no duplicate in the same row or in the same column or in the same matrix, return true. Else false
*/
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int [] row = new int[9];
		int [] col = new int[9];
		//each row and each col
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				row[j]=0;
				col[j]=0;
			}
			for(int j=0;j<9;j++){
				if(board[i][j]!='.'){
					if(row[board[i][j]-'1']>=1)
						return false;
					row[board[i][j]-'1']++;
				}
				if(board[j][i]!='.'){
					if(col[board[j][i]-'1']>=1)
						return false;
					col[board[j][i]-'1']++;
				}
			}
		}
		//each 3*3 matrix
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){//one 3*3 matrix start from (i*3,j*3)
				int rindex=i*3;
				int cindex=j*3;
				for(int jj=0;jj<9;jj++){
					row[jj]=0;
				}
				for(int m=0;m<3;m++){
					for(int n=0;n<3;n++){
						if(board[rindex+m][cindex+n]!='.'){
							if(row[board[rindex+m][cindex+n]-'1']>=1)
								return false;
							row[board[rindex+m][cindex+n]-'1']++;
						}
					}
				}
			}
		}
		return true;
    }
}