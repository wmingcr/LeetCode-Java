class Solution {
    public int maxProfit(int[] prices) {
        //check validity of prices
        if(prices == null || prices.length == 0 || prices.length == 1){
            return 0;
        }
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                //find the greatest profit
                max = prices[j] - prices[i] > max ? prices[j] - prices[i] : max;
            }
        }
        return max;
    }
}
