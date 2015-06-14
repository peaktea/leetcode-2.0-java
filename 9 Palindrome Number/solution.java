public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;//if is negative , return false;
        double doublex=(double)x;
        double reverse=0;
        double tmpx=doublex;
		while(tmpx!=0){
		    double leftx=tmpx-Math.floor(tmpx/10)*10;
			reverse=reverse*10+leftx;
			tmpx=Math.floor(tmpx/10);
		}
		if(reverse==doublex)return true;
		return false;
    }
}