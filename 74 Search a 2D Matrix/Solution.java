public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //find which row
		int startindex=0;
		int endindex=matrix.length-1;
		// the following step ensure the target is not 
		// out bounds the matrix
		if(target<matrix[0][0]||
		target>matrix[matrix.length-1][matrix[0].length-1])
			return false;
		while(startindex<=endindex){
			int mid = (startindex+endindex)/2;
			int value=matrix[mid][0];
			if(value==target){return true;}
			if(value<target){startindex=mid+1;}
			if(value>target){endindex=mid-1;}
		}
		// search the target in the row
		int left=0;
		int right=matrix[0].length-1;
		while(left<=right){
			int mid=(left+right)/2;
			if(matrix[endindex][mid]==target) return true;
			if(matrix[endindex][mid]>target) right=mid-1;
			else{
				left=mid+1;
			}
		}
		return false;
    }
}