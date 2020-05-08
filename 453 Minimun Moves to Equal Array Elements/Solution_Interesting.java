class Solution {
    public int minMoves(int[] nums) {
        //validity
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        //sortion
        Arrays.sort(nums);
        
        //initialization
        int step = 0;
        
        for(int i = nums.length-1; i > 0; i --){
            step += nums[i] - nums[0];
        }
        
        return step;
    }
}
