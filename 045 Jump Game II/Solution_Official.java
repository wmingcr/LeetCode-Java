//remaining to be understood clearly,
//method#2, https://leetcode-cn.com/problems/jump-game-ii/solution/tiao-yue-you-xi-ii-by-leetcode-solution/

class Solution {
    public int jump(int[] nums) {
        //validity
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int step = 0;
        int maxPosition = 0;
        int end = 0;
        
        for(int i = 0; i < nums.length-1; i ++){
            
            maxPosition = Math.max(maxPosition, nums[i]+i);
            
            if(i == end){
                end = maxPosition;
                step++;
            }
        }
        
        return step;
    }
}
