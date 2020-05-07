class Solution {
    public int jump(int[] nums) {
        //validity
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        //recording the smallest step to reach each element
        int [] arr = new int [nums.length];
        
        for(int i = 1; i < arr.length; i ++){
            arr[i] = Integer.MAX_VALUE;
        }
        
        int maxJump = 0;
        for(int i = 0; i < nums.length; i ++){
            
            if(maxJump < i){
                return -1;
            }
            
            maxJump = Math.max(maxJump, nums[i]+i);
            
            for(int j = 1; j <= nums[i] && i+j < arr.length; j++){
                arr[i+j] = Math.min(arr[i+j], arr[i]+1);
            }
            
            if(maxJump >= arr.length-1){
                break;
            }
        }
        return arr[arr.length-1];
    }
}
