// median number

class Solution {
    public int minMoves2(int[] nums) {
        //validity
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        Arrays.sort(nums);
        
        int step = 0, mid = nums.length/2;
        
        for(int i = 0; i < nums.length; i ++){
            
            step += Math.abs(nums[mid] - nums[i]);
            
        }
        
        
        return step;
    }
}
