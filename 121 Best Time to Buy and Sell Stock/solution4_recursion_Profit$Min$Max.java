class Solution {
    public int maxProfit(int[] prices) {
        //check validity
        if(prices == null || prices.length <2)
            return 0;
        
        //T, O(n), S, (lgn)
        int [] arr = getProfitArray(prices, 0, prices.length - 1);
        return arr[0];
    }
    
    //Runtime: 1 ms, faster than 83.94% of Java online submissions for Best Time to Buy and Sell Stock.
    private int [] getProfitArray(int [] prices, int left, int right){
        if(left == right)
            //array, profit, min, and max
            return new int [] {0, prices[left], prices[right]};
        int mid = left + ((right - left)>>1);
        int [] leftProfit = getProfitArray(prices, left, mid);
        int [] rightProfit = getProfitArray(prices, mid + 1, right);
        rightProfit[0] = Math.max(rightProfit[2] - leftProfit[1], Math.max(rightProfit[0], leftProfit[0]));//get max Profit
        rightProfit[1] = Math.min(rightProfit[1], leftProfit[1]);//get min
        rightProfit[2] = Math.max(rightProfit[2], leftProfit[2]);//get max
        return rightProfit;
    }
}
