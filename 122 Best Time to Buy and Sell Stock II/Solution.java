/*
	try to do as many stock transactions as possible.
*/
public class Solution {
    public int maxProfit(int[] prices) {
		if(prices==null||prices.length==0) return 0;
        int maxprofit=0;
		int premin=prices[0];
		for(int i=1;i<prices.length;i++){
			if(prices[i]>prices[i-1]){
				continue;
			}else{
				maxprofit+=(prices[i-1]-premin);
				premin=prices[i];
			}
		}
		maxprofit+=(prices[prices.length-1]-premin);
		return maxprofit;
    }
}