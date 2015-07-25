public class Solution {
    public int numDecodings(String s) {
		if(s==null||s.compareTo("")==0) return 0;
        if(s.length()==1){
			if(s.charAt(0)=='0') return 0;
			else return 1;
		}
		int [] num = new int[s.length()];
		num[0]=1;
		char c0=s.charAt(0);
		char c1=s.charAt(1);
		///////////// '0' is special ///////////////////////////////////////////////////////////////
		if(c0=='0') return 0;
		if(c1=='0'&&(c0=='1'||c0=='2')) num[1]=1;
		if(c1=='0'&&!(c0=='1'||c0=='2')) return 0;
		////////////consider the case which should add two order results ////////////////////////
		if((c0=='1'&&c1!='0')||(c0=='2'&&c1>='1'&&c1<='6')) num[1]=2;
		else num[1]=1;
		for(int i=2;i<s.length();i++){
			char tc=s.charAt(i);
			num[i]=num[i-1];
			char tc0=s.charAt(i-2);
			char tc1=s.charAt(i-1);
			////////////current char is '0',because zero is special /////////////////////////////////
			if(tc=='0'&&(tc1=='1'||tc1=='2')){
				num[i]=num[i-2];
				continue;
			}
			if(tc=='0'&&!(tc1=='1'||tc1=='2')){
				return 0;
			}
			////////////consider the case which should add two order results ////////////////////////
			if((tc1=='1'&&c1!='0')||(tc1=='2'&&tc>='1'&&tc<='6')){
				num[i]=num[i-1]+num[i-2];
			}
		}
		return num[num.length-1];
    }
}