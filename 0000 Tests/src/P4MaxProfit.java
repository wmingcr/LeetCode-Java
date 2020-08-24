public class P4MaxProfit {

    public static void main(String[] args) {
        int[] prices = {2, 4, 1, 5, 2, 6, 7};
        int[] algo = {0, 1, 0, 0, 1, 0, 0};
        int k = 4;
        System.out.println (maxRevenueFromStocks (prices, algo, k));
    }

    public static int maxRevenueFromStocks(int[] prices, int[] algo, int k){
        if(prices == null || prices.length == 0 || algo == null || algo.length == 0){
            return 0;
        }

        int curSum = 0, n = algo.length;
        for(int i = 0; i < k; i ++){
            curSum += prices[i];
        }

        int resSum = 0;
        for(int i = k; i < n; i ++){
            resSum += algo[i] == 1 ? prices[i] : -prices[i];
        }

        int maxProfit = curSum + resSum;

        for(int i = k; i < n; i ++){
            curSum = curSum + prices[i] - prices[i - k];
            resSum += algo[i - k] == 1 ? prices[i - k] : -prices[i-k];
            resSum -= algo[i] == 1 ? prices[i] : -prices[i];
            maxProfit = Math.max(maxProfit, curSum + resSum);
        }

        return maxProfit;
    }
}
