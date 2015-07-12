/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring. 

For "(()", the longest valid parentheses substring is "()", which has length = 2. 

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. 

*/
import java.util.*;

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
		boolean flag[] = new boolean[s.length()];
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(c=='('){
				stack.add(i);
			}else{
				if(!stack.isEmpty()){
					int preindex = stack.pop();
					flag[preindex]=true;
					flag[i]=true;
				}
			}
		}
		int maxcount=0;
		int tmpcount=0;
		for(int i=0;i<flag.length;i++){
			if(flag[i]){
				tmpcount++;
			}else{
				if(tmpcount>maxcount){
					maxcount=tmpcount;
				}
				tmpcount=0;
			}
		}
		if(tmpcount>maxcount){
			maxcount=tmpcount;
		}
		return maxcount;
    }
}