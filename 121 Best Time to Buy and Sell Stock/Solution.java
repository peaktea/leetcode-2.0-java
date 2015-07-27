/*
greedy method can be used here. Loop from left to right, we record the minimum prices, if the current price is larger than the current minimum price, try to sell the stock and
try to update the max profit. Otherwise update the minimum price.
*/
public class Solution {
    public int maxProfit(int[] prices) {
		if(prices==null||prices.length==0) return 0;
        int minprice = prices[0];
		int maxprofit=0;
		for(int i=1;i<prices.length;i++){
			if(prices[i]>minprice){
				maxprofit=maxprofit>(prices[i]-minprice)?maxprofit:(prices[i]-minprice);
			}else{
				minprice=prices[i];
			}
		}
		return maxprofit;
    }
}