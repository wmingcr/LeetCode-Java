/**You may not engage in multiple transactions at the same time.

You may not be able to sell it and buy it again at the same day.
Which means, you have to find the valley, and the peak, then you do the transaction.

*/
class Solution {
    public int maxProfit(int[] prices) {
        //check validity
        if(prices == null || prices.length <= 1){
            return 0;
        }
        int min = prices[0];
        int max = prices[0];
        int maxProfit = 0;
        int i = 0;
        while(i < prices.length - 1){
            while(i < prices.length - 1 && prices[i] >= prices[i + 1]){
                i ++;
            }
            min = prices[i];
            while(i < prices.length - 1 && prices[i] <= prices[i + 1]){
                i ++;
            }
            max = prices[i];
            maxProfit += max - min;
        }
        return maxProfit;
    }
}

//for the following way, it will not work for [7,1,5,3,6,4]. There is a little difference. 

//Have a check every time, to remind you the reason why it will not work.

class Solution {
    public int maxProfit(int[] prices) {
        //check validity
        if(prices == null || prices.length == 0 || prices.length == 1){
            return 0;
        }
        //recording max profit
        int maxProfit = 0, min = prices[0], max = prices[0], i = 1;
        while(i < prices.length){
            while(i < prices.length && prices[i] <= prices[i-1]){
                min = prices[i++];
            }
            while(i < prices.length && prices[i] >= prices[i-1]){
                max = prices[i++];
            }
            maxProfit += (max - min);
        }
        return maxProfit;
    }
}

