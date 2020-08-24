public class DP1 {
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int n = nums.length;
            int[] maxProfit = new int[n];

            for (int i = 0; i < n; i++) {
                maxProfit[i] = getMax (maxProfit, 0, i - 2) + nums[i];
            }

            if (n == 1) {
                return maxProfit[0];
            }

            return Math.max (maxProfit[n - 2], maxProfit[n - 1]);
        }

        private int getMax(int[] maxProfit, int start, int end) {
            if (start > end) {
                return 0;
            }
            int max = Integer.MIN_VALUE;
            for (int i = start; i <= end; i++) {
                if (maxProfit[i] > max) {
                    max = maxProfit[i];
                }
            }
            return max;
        }
    }
}
