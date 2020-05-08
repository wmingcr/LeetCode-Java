//https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/solution/zui-xiao-yi-dong-ci-shu-shi-shu-zu-yuan-su-xiang-d/

class Solution {
    public int minMoves(int[] nums) {
        //validity
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int min = nums[0];
        long sum = 0;
        
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] < min){
                min = nums[i];
            }
            sum += nums[i];
        }
        
        return (int)(sum - min*nums.length);
        
    }
}
