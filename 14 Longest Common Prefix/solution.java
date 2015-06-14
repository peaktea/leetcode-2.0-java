public class Solution {
    public String longestCommonPrefix(String[] strs) {
		//corner case one
		if(strs.length==0) return "";//
		int length=Integer.MAX_VALUE;
		for(int i=0;i<strs.length;i++){
			length=length<strs[i].length()?length:strs[i].length();
		}
		//corner case two
		if(length==0) return "";
        for(int i=0;i<length;i++){
			char pivot=strs[0].charAt(i);
			for(int j=1;j<strs.length;j++){
				if(strs[j].charAt(i)!=pivot){
					return strs[0].substring(0,i); 
				}
			}
		}
		return strs[0].substring(0,length);
    }
}