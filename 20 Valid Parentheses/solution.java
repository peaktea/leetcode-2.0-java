import java.util.*;

public class Solution {
    public boolean isValid(String s) {
		Stack<String> stack=new Stack<String>();
        for(int i=0;i<s.length();i++){
			String kuohao = s.substring(i,i+1);
			if(kuohao.compareTo(")")==0){
				if(stack.isEmpty()){
					return false;
				}else{
					String kuo = stack.pop();
					if(kuo.compareTo("(")!=0)return false;
				}
			}else if(kuohao.compareTo("]")==0){
				if(stack.isEmpty()){
					return false;
				}else{
					String kuo=stack.pop();
					if(kuo.compareTo("[")!=0)return false;
				}
			}else if(kuohao.compareTo("}")==0){
				if(stack.isEmpty()){
					return false;
				}else{
					String kuo=stack.pop();
					if(kuo.compareTo("{")!=0)return false;
				}
			}else{
				stack.add(kuohao);
			}
		}
		if(stack.isEmpty()) return true;
		return false;
    }
}