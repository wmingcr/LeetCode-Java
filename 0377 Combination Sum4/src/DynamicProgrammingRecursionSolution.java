import java.util.Arrays;

public class DynamicProgrammingRecursionSolution {

    public static void main(String[] args) {
        // this method is from Youtube, 花花酱
    }

    class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            Arrays.fill(dp, -1);
            dp[0] = 1;
            return helper(nums, target, dp);
        }

        private int helper(int[] nums, int target, int[] dp){
            if(target < 0){
                return 0;
            }
            if(dp[target] != -1){
                return dp[target];
            }
            int ans = 0;
            for(int num : nums){
                ans += helper(nums, target - num, dp);
            }
            return dp[target] = ans;
        }
    }
}
