//pass array one time,
class Solution {
    public int maxSubArray(int[] nums) {
        //check validity
        if(nums == null || nums.length == 0){
            return -1;
        }
        return solution1(nums);
    }
    
    private int solution1(int[] nums){
        int sum = -1, total = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i ++){
            if(sum < 0){
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            if(sum > total){
                total = sum;
            }
        }
        return total;
    }
}
