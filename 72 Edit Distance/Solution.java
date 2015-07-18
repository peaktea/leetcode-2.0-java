public class Solution {
    public int minDistance(String word1, String word2) {
        int [][] nums = new int[word1.length()+1][word2.length()+1];
		// the edge ,just when one string is empty, the minimum step
		// to transfer is the length of the non-empty string
		for(int i=1;i<word1.length()+1;i++){
			nums[i][0]=i;
		}
		for(int i=1;i<word2.length()+1;i++){
			nums[0][i]=i;
		}
		for(int i=0;i<word1.length();i++){
			for(int j=0;j<word2.length();j++){
				char c1=word1.charAt(i);
				char c2=word2.charAt(j);
				if(c1==c2){//when the character is the same
					nums[i+1][j+1]=nums[i][j];;
				}else{
					//modify one character
					int nummodify = nums[i][j]+1;
					//delete one character
					int numdelete = Math.min(nums[i][j+1],nums[i+1][j])+1;
					nums[i+1][j+1] = Math.min(nummodify,numdelete);
				}
			}
		}
		return nums[word1.length()][word2.length()];
    }
}