public class Solution {
    public int divide(int a, int b) {
		double dividend = a;
		double divisor =b;
		//////////////////////////very good corner case below
		/*
			我们知道负整数比正整数多了一个状态。两者的绝对值相差是一，但是如果使用这个负整数*-1，结果是得到了最大的正整数。但是我们按照常规的将两者转化为
			正数在进行计算的方式，会溢出。因为最小的负数，转化为正数时，就已经超了。我们可以将其存在一个double当中，但是最后转化为int是也是会溢出的。
			所以这是一个非常好的Corner case
			如果a是最小的负整数，也就是Integer.MIN_INT
		*/
		if(Math.abs(b)==1){
			if(b>0) return a;//1
			else{//-1
				if(a>0){
					return 0-a;
				}else if(a==Integer.MIN_VALUE){
					return Integer.MAX_VALUE;
				}else{
					return a*b;
				}
			}
		}
		////////////////////////very good corner case up
        if(divisor==0||divisor==0) return 0;
		int flag = dividend*divisor<0? -1:1;
		
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		
		int sum=0;
		
		while(dividend!=0){
			if(dividend<divisor){
				return sum*flag;
			}
			//assure there at least one 
			double pre=divisor;
			int precount=1;
			double tmp=divisor;
			while(tmp+tmp<dividend){
				pre=tmp+tmp;
				tmp+=tmp;
				precount=precount+precount;
			}
			
			if(tmp+tmp==dividend){
				return (precount+precount)*flag;
			}
			dividend=dividend-tmp;
			sum=sum+precount;
		}
		return (int)(sum*flag);
    }
}