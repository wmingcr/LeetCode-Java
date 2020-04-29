class Solution {
    public int maxSubArray(int[] nums) {
        //check validity
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        return solutionDP(nums);
        
    }
    
    private int solutionDP(int [] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i ++){
            if(arr[i-1] > 0){
                arr[i] += arr[i-1];
            }
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
