public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
		if(s1==null||s2==null||s3==null) return false;
		if((s1.length()+s2.length())!=s3.length()) return false;
		if(s1.compareTo("")==0||s2.compareTo("")==0){
			if(s3.compareTo(s1+s2)==0) return true;
			else return false;
		}
        boolean [][] flag = new boolean[s1.length()+1][s2.length()+1];
		flag[0][0]=true;
		//border case here
		for(int i=0;i<s1.length();i++){
			if(s1.charAt(i)==s3.charAt(i)){
				flag[i+1][0]=true;
			}
			else break;
		}
		for(int i=0;i<s2.length();i++){
			if(s2.charAt(i)==s3.charAt(i)){
				flag[0][i+1]=true;
			}else break;
		}
		//flag[0][1]=s3.charAt(0)==s2.charAt(0)?true:false;
		//flag[1][0]=s3.charAt(0)==s1.charAt(0)?true:false;
		for(int i=1;i<s1.length()+1;i++){
			for(int j=1;j<s2.length()+1;j++){
				char t=s3.charAt(i+j-1);
				if(s1.charAt(i-1)==t&&flag[i-1][j]){
					flag[i][j]=true;
				}
				else if(s2.charAt(j-1)==t&&flag[i][j-1]){
					flag[i][j]=true;
				}
				else{
					flag[i][j]=false;
				}
			}
		}
		return flag[s1.length()+1][s2.length()+1];
    }
}