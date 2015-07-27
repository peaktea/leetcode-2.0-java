public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null||s.length()==0) return true;
		int leftindex=0;
		int rightindex=s.length()-1;
		while(leftindex<rightindex){
			while(leftindex<rightindex&&!Character.isLetterOrDigit(s.charAt(leftindex))) leftindex++;
			while(leftindex<rightindex&&!Character.isLetterOrDigit(s.charAt(rightindex)))rightindex--;
			if(Character.toLowerCase(s.charAt(leftindex))!=Character.toLowerCase(s.charAt(rightindex))) return false;
			leftindex++;
			rightindex--;
		}
		return true;
    }
}