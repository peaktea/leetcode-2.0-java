//here compute the catlan number in fact!

public class Solution {
    public int numTrees(int n) {
		/*
		do not know why catlan not work here
        double numerator=1;
		double denominator=1;
		for(int i=0;i<n;i++){
			numerator*=2*n-i;
			denominator*=(i+1);
		}
		double res=numerator/(denominator*(n+1));
		return (int)res;
		*/
		/*
			Using DP method to calculate the tree number for each node number.
		*/
		int [] num = new int[n+1];//the tree number for each node number
		num[0]=1;
		for(int i=1;i<=n;i++){
			if(i<3) num[i]=i;
			else{
				for(int j=1;j<=i;j++){
					num[i]+=num[j-1]*num[i-j];
				}
			}
		}
		return num[n];
    }
}