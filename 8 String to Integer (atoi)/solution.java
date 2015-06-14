public class Solution {
    public int myAtoi(String str) {
        if(str==null) return 0;
        str=str.trim();
		if(str.length()==0) return 0;
		int flag=1;
		int startindex=0;
		if(str.charAt(0)=='-'||str.charAt(0)=='+'){
		    if(str.charAt(0)=='-')
			    flag=-1;
			startindex++;
		}
		double res=0;
		for(int i=startindex;i<str.length();i++){
			char digit = str.charAt(i);
			if(digit>='0'&&digit<='9'){
				res=res*10+(digit-'0');
			}
			else{// if is illegal , return the legal part from the first character to current index
				if(res*flag>Integer.MAX_VALUE){return Integer.MAX_VALUE;}
		        if(res*flag<Integer.MIN_VALUE){return Integer.MIN_VALUE;}
		        return (int)(res*flag);
			}
		}
		if(res*flag>Integer.MAX_VALUE){return Integer.MAX_VALUE;}
		if(res*flag<Integer.MIN_VALUE){return Integer.MIN_VALUE;}
		return (int)(res*flag);
    }
}