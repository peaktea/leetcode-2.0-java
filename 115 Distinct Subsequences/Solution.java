public class Solution {
    public int numDistinct(String s, String t) {
        int [][]num=new int[s.length()+1][t.length()+1];
		for(int i=0;i<=s.length();i++){
			num[i][0]=1;
		}
		for(int i=0;i<t.length();i++){
			num[0][i]=0;
		}
		for(int i=1;i<s.length()+1;i++){
			for(int j=1;j<t.length()+1;j++){
				num[i][j]=num[i-1][j];
				if(s.charAt(i-1)==t.charAt(j-1)){
					num[i][j]+=num[i-1][j-1];
				}
			}
		}
		return num[s.length()][t.length()];
    }
}