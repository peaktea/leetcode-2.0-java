public class Solution {
    public int reverse(int y) {
        double x=y;
		int flag = x<0? -1:1;
		if(x<0) x=-x;
        double res=0;
		while(x!=0){
			//get the left number
			double left = x-Math.floor(x/10)*10;
			res=res*10+left;
			x=Math.floor(x/10);
		}
		// if overflow or lowerflow , return 0 exectely
		if(res*flag>Integer.MAX_VALUE) return 0;
		if(res*flag<Integer.MIN_VALUE) return 0;
		return (int)(res*flag);
    }
}