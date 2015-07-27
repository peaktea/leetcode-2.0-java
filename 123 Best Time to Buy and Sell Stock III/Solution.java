/*
	���д�ǰ����ʹӺ���ǰ�ļ��㡣
	leftmost[i]��ʾ��ʱ��ڵ�i�����������ܻ�õ��������档
	rightmost[j]��ʾ��ʱ��ڵ�j���й������ܻ�õ�������档
	�����ٽ�������ͳ�ƣ�ͳ����ʱ��ڵ�i֮ǰ���ܻ�õ�������棬ͳ����ʱ��ڵ�j֮�����ܻ�õ�������档
	��Ϊֻ���������ֻ�����ν��ף��������ͳ����ĳ��ʱ��ڵ�֮ǰ��֮�����ܻ�õ��������֮�͵����ֵ������������Ҫ�ġ�
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
		int [] leftmost = new int[prices.length];
		int [] rightmost = new int[prices.length];
		int minprices=prices[0];
		for(int i=0;i<prices.length;i++){
			leftmost[i]=prices[i]>minprices?(prices[i]-minprices):0;
			minprices=minprices<prices[i]?minprices:prices[i];
		}
		int maxprices=prices[prices.length-1];
		for(int i=prices.length-1;i>=0;i--){
			rightmost[i]=prices[i]<maxprices?(maxprices-prices[i]):0;
			maxprices=maxprices>prices[i]?maxprices:prices[i];
		}
		for(int i=1;i<prices.length;i++){
			leftmost[i]=leftmost[i]>leftmost[i-1]?leftmost[i]:leftmost[i-1];
		}
		for(int i=prices.length-2;i>=0;i--){
			rightmost[i]=rightmost[i]>rightmost[i+1]?rightmost[i]:rightmost[i+1];
		}
		int maxprofit=0;
		for(int i=0;i<prices.length;i++){
			int tmp=leftmost[i]+rightmost[i];
			if(tmp>maxprofit){
				maxprofit=tmp;
			}
		}
		return maxprofit;
    }
}