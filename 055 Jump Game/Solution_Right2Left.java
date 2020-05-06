class Solution {
    public boolean canJump(int[] nums) {
        //validity
        if(nums == null || nums.length == 0){
            return false;
        }
        
        int min = nums.length-1;
        
        for(int i = nums.length-1; i >= 0; i --){
            if(nums[i]+i >= min){
                min = i;
            }
        }
        return min == 0;
    }
}
