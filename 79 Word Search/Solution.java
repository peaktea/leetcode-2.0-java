public class Solution {
	private boolean find(int row,int col,boolean [][]visited,String word,int index,
		char [][]board){
		if(row<0||col<0||row>=board.length||col>=board[0].length||visited[row][col]){
			return false;
		}
		if(board[row][col]==word.charAt(index)){
			visited[row][col] = true;
			if(index==word.length()-1)
				return true;
			//up right down left
			boolean finded = find(row-1,col,visited,word,index+1,board)||
							 find(row,col+1,visited,word,index+1,board)||
							 find(row+1,col,visited,word,index+1,board)||
							 find(row,col-1,visited,word,index+1,board);
			visited[row][col]=false;
			return finded;
		}else{
			return false;
		}
	}
    public boolean exist(char[][] board, String word) {
        boolean [][] visited =new boolean[board.length][board[0].length];
		//test all the start point
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]==word.charAt(0)){
					boolean res = find(i,j,visited,word,0,board);
					if(res) return res;
				}
			}
		}
		return false;
    }
}