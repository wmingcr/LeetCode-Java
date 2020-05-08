class Solution {
    public int minMoves(int[] nums) {
        //validity
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int min = 0, max = 0, step = 0;
        
        while(true){
            
            for(int i = 0; i < nums.length; i ++){
                if(nums[i] > nums[max]){
                    max = i;
                }
                if(nums[i] < nums[min]){
                    min = i;
                }
            }
            
            int dif = nums[max] - nums[min];
            
            if(dif == 0){
                break;
            }
            
            step += dif;
            
            for(int i = 0; i < nums.length; i ++){
                if(i != max){
                    nums[i] += dif;
                }
            }
        }
        
        return step;
    }
}
