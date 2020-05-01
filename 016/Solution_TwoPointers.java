/*
https://leetcode-cn.com/problems/3sum-closest/solution/hua-jie-suan-fa-16-zui-jie-jin-de-san-shu-zhi-he-b/
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //validity
        if(nums == null || nums.length < 3){
            return -1;
        }
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i ++){
            int j = i+1, k = nums.length-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(target - sum) < Math.abs(target - ans)){
                    ans = sum;
                }
                if(sum > target){
                    k--;
                }else if(sum < target){
                    j++;
                }else{
                    return ans;
                }
            }
        }
        return ans;
    }
}
