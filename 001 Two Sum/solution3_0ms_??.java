class Solution {
    public int[] twoSum(int[] nums, int target) {  
    
        int max = 4095;
        int[] dp = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            int tempVal = target - nums[i];
            int position = dp[tempVal & max];
            if (position != 0)
                return new int[]{position - 1, i};
            dp[nums[i] & max] = i + 1;
        }
        return null;
    }
}
