import java.util.*;

public class Solution {
    public String multiply(String num1, String num2) {
		//to discard some noise, we first pre process all the digits , and store them in a vector.
        Vector<Integer> n1=new Vector<Integer>();
		Vector<Integer> n2=new Vector<Integer>();
		for(int i=num1.length()-1;i>=0;i--){
			if(Character.isDigit(num1.charAt(i))){
				n1.add(num1.charAt(i)-'0');
			}
		}
		for(int i=num2.length()-1;i>=0;i--){
			if(Character.isDigit(num2.charAt(i))){
				n2.add(num2.charAt(i)-'0');
			}
		}
		//multiply the two numbers
		int multiplysum[]=new int[num1.length()+num2.length()+2];
		for(int i=0;i<n1.size();i++){
			for(int j=0;j<n2.size();j++){
				int tmp = n1.get(i)*n2.get(j);
				multiplysum[i+j]+=tmp;
			}
		}
		//compute the carry bit
		for(int i=0;i<multiplysum.length-1;i++){
			int tmp = multiplysum[i];
			multiplysum[i]=tmp%10;
			multiplysum[i+1]+=tmp/10;
		}
		//discard the zero number in the higher bit, and return the result string
		StringBuffer strbuf = new StringBuffer();
		boolean started=false;
		for(int i=multiplysum.length-1;i>=0;i--){
			if(started){
				strbuf.append(multiplysum[i]);
			}
			else{
				if(multiplysum[i]!=0){
					strbuf.append(multiplysum[i]);
					started=true;
				}
			}
		}
		if(started==false) return "0";
		return strbuf.toString();
    }
}