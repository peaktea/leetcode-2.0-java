public class Solution {

    public String longestPalindrome(String s) {
		int maxlength=0;
		String maxstr=null;
        for(int i=0;i<s.length();i++){
			//single center
			int left=i-1;
			int right=i+1;
			int tmplength=1;
			while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
				tmplength+=2;
				left--;
				right++;
			}
			String maxstr1=s.substr(left+1,right);
			//two center
			int left1=i;
			int right1=i+1;
			int tmplength2=0;
			while(left1>=0&&right1<s.length()&&s.charAt(left1)==s.charAt(right1)){
				tmplength2+=2;
				left1--;
				right1++;
			}
			String maxstr2=s.substr(left+1,right);
			String tmpstr=null;
			if(tmplength>tmplength2) tmpstr=maxstr1;
			else tmpstr=maxstr2
			if(tmpstr.length()>maxlength) maxstr=tmpstr;
		}
		return maxstr;
    }
}