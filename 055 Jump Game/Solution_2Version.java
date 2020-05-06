class Solution {
    public boolean canJump(int[] nums) {
        //validity
        if(nums == null || nums.length == 0){
            return false;
        }
        
        //the max index we can reach
        int maxJump = 0;
        int i = 0;
        
        //traverse all index
        for( ; i <= maxJump && maxJump < nums.length-1; i ++){
            maxJump = Math.max(maxJump, i+nums[i]);
        }
        
        return maxJump >= nums.length-1;
    }
}
