import java.util.*;

class Solution {
    public String simplifyPath(String path) {
			Stack<String> stack = new Stack<String>();
			String [] paths = path.split("/");
			for(int i=0;i<paths.length;i++){
				String pathone=paths[i];
				if(pathone.compareTo("")==0){continue;}
				if(pathone.compareTo(".")==0){continue;}
				if(pathone.compareTo("..")==0){
					if(!stack.isEmpty())
						stack.pop();
					continue;
				}
				stack.push(pathone);
			}
			Stack<String> swapstack = new Stack<String>();
			while(!stack.isEmpty()){
				String tmp = stack.pop();
				swapstack.push(tmp);
			}
			StringBuffer res =new StringBuffer();
			while(!swapstack.isEmpty()){
				String pathone=swapstack.pop();
				res.append("/");
				res.append(pathone);
			}
			String strres = res.toString();
			// the first forward slash should be appended last, because if the path is not empty, then res become \\patho...
			// there is 2 \\.
			return strres.equals("")? "/":strres;
    }
};