public class Solution {
    public int divide(int a, int b) {
		double dividend = a;
		double divisor =b;
		//////////////////////////very good corner case below
		/*
			����֪��������������������һ��״̬�����ߵľ���ֵ�����һ���������ʹ�����������*-1������ǵõ����������������������ǰ��ճ���Ľ�����ת��Ϊ
			�����ڽ��м���ķ�ʽ�����������Ϊ��С�ĸ�����ת��Ϊ����ʱ�����Ѿ����ˡ����ǿ��Խ������һ��double���У��������ת��Ϊint��Ҳ�ǻ�����ġ�
			��������һ���ǳ��õ�Corner case
			���a����С�ĸ�������Ҳ����Integer.MIN_INT
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