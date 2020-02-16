//T:O(n), S:O(1)
//somebody is a genius who figured out this method,
class Solution {
    public int maxProfit(int[] prices) {
        //check validity of prices
        if(prices == null || prices.length == 0 || prices.length == 1){
            return 0;
        }
        //relatively lower price
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice){
            //recording the lower price
                minPrice = prices[i];
            }else{
                if(prices[i] - minPrice > maxProfit){
                //recording the bigger range
                    maxProfit = prices[i] - minPrice;
                }
            }
        }
        return maxProfit;
    }
}
