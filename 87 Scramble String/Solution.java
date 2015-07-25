public class Solution {
    public boolean isScramble(String s1, String s2) {
        int len1=s1.length();
		int len2=s2.length();
		if(len1!=len2) return false;
		boolean [][][] flag = new boolean[s1.length()][s2.length()][s1.length()+1];
		char [] chararray1 = s1.toCharArray();
		char [] chararray2 = s2.toCharArray();
		for(int i=0;i<s1.length();i++){
			for(int j=0;j<s2.length();j++){
				flag[i][j][1] = chararray1[i]==chararray2[j]? true:false;
			}
		}
		for(int len=2;len<=len1;len++){
			//the initial way for i,j below will ensure the i,j in the next computation will 
			//not overflow or underflow the index of chararray1 and chararray2
			for(int i=len1-len;i>=0;i--){
				for(int j=len1-len;j>=0;j--){
					boolean res=false;
					for(int sublen=1;sublen<len&&!res;sublen++){
						if(flag[i][j][sublen]&&flag[i+sublen][j+sublen][len-sublen])
							res=true;
						// the corner case here is the j+len-sublen,not j+sublen
						if(!res&&flag[i][j+len-sublen][sublen]&&flag[i+sublen][j][len-sublen])
							res=true;
					}
					flag[i][j][len]=res;
				}
			}
		}
		return flag[0][0][len1];
    }
}