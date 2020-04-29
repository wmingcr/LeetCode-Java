class Solution {
    public int maxProfit(int[] prices) {
        //check validity of prices
        if(prices == null || prices.length == 0 || prices.length == 1){
            return 0;
        }
        
        
        //Runtime: 1 ms, faster than 83.37% of Java online submissions for Best Time to Buy and Sell Stock.
        //Time Complexity: O(n), Space Complexity: O(1)
        //return valleyAndPeak(prices);
        
        /**
        * turn it into max sub array
        * Time Complexity: O(n), Space Complexity: O(1)
        * Runtime: 1 ms, faster than 83.37% of Java online submissions for Best Time to Buy and Sell Stock.
        */
        //return withMaxSubArray(prices);
        
        /**
        <divid and conquer>
        left Profit, right Profit, cross Profit.
        return the greatest one,
        
        Time Complexity: O(nlgn), 
        
        Space Complexity: O(?) nononononono
        Since we are using recursion, Space Complexity is O(lgn)
        */
        return divideAndConquer(prices, 0, prices.length - 1);
    }
    
    private int divideAndConquer(int [] arr, int left, int right){
        //int maxProfit = 0; 
        //buying and selling it at the same day,
        if(left == right)
            //return maxProfit;
            return 0;
        
        //divide it into two half,
        int mid = left + ( (right - left) >> 1);
        
        int leftProfit = divideAndConquer(arr, left, mid);
        int rightProfit = divideAndConquer(arr, mid + 1, right);
        
        //get the max Cross Profit
        
        //get the min Left
        int minLeft = arr[left];
        for(int i = left + 1; i <= mid; i++){
            minLeft = arr[i] < minLeft ? arr[i] : minLeft;
        }
        //get the max Right
        int maxRight = arr[mid+1];
        for(int i = mid + 2; i <= right; i++){
            maxRight = arr[i] > maxRight ? arr[i] : maxRight;
        }
        
        int crossProfit = maxRight - minLeft;
        
        return Math.max(leftProfit, Math.max(crossProfit, rightProfit));
        
    }
    
    
    private int withMaxSubArray(int [] arr){
        //profit of everyday, buy it today and sell it tomorrow,
        int [] f = new int [arr.length - 1];
        for(int i = 1; i < arr.length; i++){
            f[i - 1] = arr[i] - arr[i - 1];
        }
        int maxProfit = 0, preSum = 0;
        for(int i = 0; i < f.length; i++){
            if(preSum > 0){
                preSum += f[i];
            }else{
                preSum = f[i];
            }
            maxProfit = maxProfit > preSum ? maxProfit : preSum;
        }
        return maxProfit;
    }
    
    private int valleyAndPeak(int [] arr){
        int valley = Integer.MAX_VALUE, peak = Integer.MIN_VALUE;
        int maxPro = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < valley)
                valley = arr[i];
            peak = arr[i];
            maxPro = maxPro > peak - valley ? maxPro : peak - valley;
        }
        return maxPro;
    }
}

//-----

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;

        int buy[] = new int[len];
        int sell[] = new int[len];
        int temp = prices[0];
        for (int i = 0; i < len; i++) {
            temp = Math.min (temp, prices[i]);
            buy[i] = temp;
        }

        temp = prices[len - 1];

        for (int i = len - 1; i >= 0; i--) {
            temp = Math.max (temp, prices[i]);
            sell[i] = temp;
        }
        int result = 0;
        for (int i = 0; i < len; i++) {
            result = Math.max (result, sell[i] - buy[i]);
        }

        return result;
    }
}

