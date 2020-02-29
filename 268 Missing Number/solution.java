class Solution {
    public int missingNumber(int[] nums) {
        //check validity
        if(nums == null || nums.length == 0){
            return -1;
        }
        int sum = 0, len = nums.length;
        /**for(int i = 0; i < len; i ++){
            sum += nums[i];
        }*/
        //change it to foreach
        for(int num : nums){
            sum += num;
        }
        return ((len * (len + 1)) >> 1) - sum;
    }
}
