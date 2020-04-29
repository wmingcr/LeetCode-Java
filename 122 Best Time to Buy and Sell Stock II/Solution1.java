//buy it today, sell it tomorrow, if there is profit, then add it; if not, just ignore it.
class Solution {
    public int maxProfit(int[] prices) {
        //check validity
        if(prices == null || prices.length == 0 || prices.length == 1){
            return 0;
        }
        //recording max profit
        int maxProfit = 0;
        for(int i = 0; i < prices.length - 1; i++){
            //if profit is greater than 0, add it.
            maxProfit += prices[i+1] - prices[i] > 0 ? prices[i+1] - prices[i] : 0;
        }
        return maxProfit;
    }
}
