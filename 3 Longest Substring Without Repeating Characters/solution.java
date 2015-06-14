public class Solution {
	
    public int lengthOfLongestSubstring(String s) {
        int startindex[]=new int[256];
		for(int i=0;i<256;i++){
			startindex[i]=-1;
		}
		int maxlength=-1;
		int curlength=0;
		int countstart=0;
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			int index = (int) c;
			if(startindex[index]==-1){
				startindex[index]=i;
				curlength++;
			}else{
				maxlength = curlength>maxlength?curlength:maxlength;
				//clear some
				for(int k=countstart;k<startindex[index];k++){
					startindex[(int)(s.charAt(k))]=-1;
				}
				curlength=i-startindex[index];//not the maximum
				countstart=startindex[index]+1;
				startindex[index]=i;
			}
			if(i==s.length()-1){
				if(curlength>maxlength){
					maxlength=curlength;
				}
			}
		}
		if(maxlength==-1)
			return s.length();
		return maxlength;
    }
}