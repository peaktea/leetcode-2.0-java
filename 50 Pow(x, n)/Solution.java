public class Solution {
    public double myPow(double x, int n) {
        double res=1;
		double base=x;
		//n maybe negative, we should store the flag of it
		int flag1= n>0?1:-1;
		n=n>0?n:-n;
		while(n!=0){
			int flag=n%2;
			if(flag==1){
				res*=base;
			}
			base*=base;
			n=n/2;
		}
		if(flag1==-1) res=1/res;
		return res;
    }
}