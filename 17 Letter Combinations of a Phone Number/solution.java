import java.util.*;

public class Solution {
	void backtree(String digits,int index,String numgroup[],List<String> strs,String assembleone){
		if(index==digits.length()) {
			strs.add(assembleone);
			return;
		}
		String groupone=numgroup[digits.charAt(index)-'0'];
		for(int i=0;i<groupone.length();i++){
			backtree(digits,index+1,numgroup,strs,assembleone+groupone.substring(i,i+1));
		}
	}
    public List<String> letterCombinations(String digits) {
		String numgroup [] ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		List<String> res=new LinkedList<String>();
		if(digits==null||digits.compareTo("")==0) return res;
		backtree(digits,0,numgroup,res,"");
		return res;
    }
}