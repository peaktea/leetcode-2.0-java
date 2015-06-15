public class Solution {
	private String expendCenter(String s, int c1, int c2){
		while(c1>=0&&c2<s.length&&s.charAt(c1)==s.charAt(c2)){
			c1--;
			c2++;
		}
		String res = s.substring(c1+1,c2);
		return res;
	}
    public String longestPalindrome(String s) {
		int maxlength=0;
		String maxstr=null;
        for(int i=0;i<s.length();i++){
			//single center
			String substr1 = expendCenter(s,i,i);
			String substr2 = "";
			if(i>0){
				//if i > 0, then we can test the double center
				substr2 = expendCenter(s,i-1,i);
			}
			if(substr1.length()>substr2.length()&&substr1.length()>maxlength){
				maxlength=substr1.length();
				maxstr=substr1;
			}
			if(substr2.length()>substr1.length()&&substr2.length()>maxlength){
				maxlength=substr2.length();
				maxstr=substr2;
			}
		}
		return maxstr;
    }
}