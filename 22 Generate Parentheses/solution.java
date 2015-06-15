/*
	Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

	For example, given n = 3, a solution set is:

	"((()))", "(()())", "(())()", "()(())", "()()()"
*/
public class Solution {
	private void backtrack(List<String> listall, int leftnum, int rightnum, String partial,int n){
		if(leftnum==n&&rightnum==n){
			listall.add(partial);
		}
		if(leftnum<n){
			backtrack(listall,leftnum+1,rightnum,partial+"(",n);
		}
		if(rightnum<leftnum){
			backtrack(listall,leftnum,rightnum+1,partial+")",n);
		}
	}
    public List<String> generateParenthesis(int n) {
        List<String> listall = new LinkedList<String>();
		backtrack(listall,0,0,"",n);
		return listall;
    }
}