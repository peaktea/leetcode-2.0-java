/*
	进行从前往后和从后往前的计算。
	leftmost[i]表示在时间节点i进行抛售所能获得的最大的收益。
	rightmost[j]表示在时间节点j进行购买所能获得的最大收益。
	下面再进行两次统计，统计在时间节点i之前所能获得的最大收益，统计在时间节点j之后所能获得的最大收益。
	因为只有两次最多只有两次交易，因此我们统计在某个时间节点之前和之后所能获得的最大收益之和的最大值，就是我们需要的。
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