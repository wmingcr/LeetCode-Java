//while calculate every steps for each element, there might be some elements' steps are overflow, so be carefull

class Solution {
    public int minMoves2(int[] nums) {
        //validity
        if(nums == null || nums.length == 0){
            return -1;
        }
        Arrays.sort(nums);
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i ++){
            
            long steps = 0;
            
            for(int j = 0; j < nums.length; j ++){
                
                if(nums[i] > nums[j]){
                    steps += (long)nums[i] - (long)nums[j];
                }else{
                    steps += (long)nums[j] - (long)nums[i];
                }
            }
            if(steps < Integer.MAX_VALUE){
                min = Math.min(min, (int)steps);
            }
        }
        
        return min;
    }
}
