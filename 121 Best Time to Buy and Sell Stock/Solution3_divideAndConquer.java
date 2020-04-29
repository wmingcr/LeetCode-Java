/**
        <divid and conquer>
        left Profit, right Profit, cross Profit.
        return the greatest one,
        
        Time Complexity: O(nlgn), 
        
        Space Complexity: O(?) nononononono
        Since we are using recursion, Space Complexity is O(lgn)
*/
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
