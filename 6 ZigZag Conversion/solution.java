public class Solution {
    public String convert(String s, int numRows) {
		if(numRows==1||numRows==s.length()) return s;
        char [] zigzag=new char[s.length()];
		int countindex=0;
		for(int i=0;i<numRows;i++){
			if(i==0||i==numRows-1){
				int index=i;
				while(index<s.length()){
					zigzag[countindex]=s.charAt(index);
					index=index+2*numRows-2;
					countindex++;
				}
			}
			else{
				int index=i;
				while(index<s.length()){
					zigzag[countindex]=s.charAt(index);
					countindex++;//the former is executed definitely
					int index2=index+(numRows-i-1)*2;
					if(index2<s.length()){
						zigzag[countindex]=s.charAt(index2);
						countindex++;// only when this block is runned, the countindex can be incremented
					}
					index=index+2*numRows-2;
				}
			}
		}
		String zigzagstr=String.valueOf(zigzag);
		return zigzagstr;
    }
}