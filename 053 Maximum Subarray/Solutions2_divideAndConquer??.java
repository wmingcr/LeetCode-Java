class Solution {
    public int maxSubArray(int[] nums) {
        //check validity
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        return divideAndConquer(0, nums.length-1, nums);
        
    }
    
    private int divideAndConquer(int left, int right, int [] nums){
        if(left == right){
            return nums[left];
        }
        int mid = (left+right)/2;
        int leftSum = divideAndConquer(left, mid, nums);
        int rightSum = divideAndConquer(mid+1, right, nums);
        int crossSum = getCrossSum(left, mid, right, nums);
        
        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }
    
    private int getCrossSum(int left, int mid, int right, int [] nums){
        if(left == right){
            return nums[left];
        }
        int leftSum = Integer.MIN_VALUE, leftTotal = 0;
        for(int i = mid; i >= left; i --){
            leftTotal += nums[i];
            leftSum = Math.max(leftSum, leftTotal);
        }
        /**
         * why there is a big difference, why this one is working?
         */

        /*
        for(int i = left; i <= mid; i ++){
            left_Total += arr[i];
            leftSum = Math.max(leftSum, left_Total);
        }
        */
        int rightSum = Integer.MIN_VALUE, rightTotal = 0;
        for(int i = mid + 1; i <= right; i ++){
            rightTotal += nums[i];
            rightSum = Math.max(rightSum, rightTotal);
        }
        return leftSum+rightSum;
    }
    
}
