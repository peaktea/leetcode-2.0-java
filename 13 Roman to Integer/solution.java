import java.util.*;

public class Solution {
    public int romanToInt(String s) {
		Map<String,int> map =new HashMap<String,int>();
		map.put("I",1);
		map.put("V",5);
		map.put("X",10);
		map.put("L",50);
		map.put("C",100);
		map.put("D",500);
		map.put("M",1000);
        int res=0;
		for(int i=0;i<s.length();i++){
			String digit=s.substring(i,i+1);
			int num1=map.get(digit);
			res+=num1;
			if(i!=0){
				String digit2=s.substring(i-1,i);
				int num2=map.get(digit2);
				if(num2<num1){//when the former number is smaller than this one, we should minus it 
					res-=2*num2;
				}
			}
		}
		return res;
    }
}