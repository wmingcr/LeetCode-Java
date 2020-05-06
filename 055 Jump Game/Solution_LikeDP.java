class Solution {
    public boolean canJump(int[] nums) {
        //validity
        if(nums == null || nums.length == 0){
            return false;
        }
        
        //the max index we can reach
        int maxJump = 0;
        
        //traverse all index
        for(int i = 0; i < nums.length; i ++){
            
            //if maxJump cant reach current i
            if(maxJump < i){
                return false;
            }
            
            maxJump = Math.max(maxJump, nums[i]+i);
            
            //if maxJupm is greater or equal than last element, (can reach last element)
            if(maxJump >= nums.length-1){
                return true;
            }
        }
        
        //doesnt matter what we will return here
        return false;
    }
}
