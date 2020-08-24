public class DP_Better {
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }

            return Math.max (max (nums, 0, n - 1), max (nums, 1, n));
        }

        private int max(int[] nums, int start, int end) {
            int L = 0, R = 0;
            for (int i = start; i < end; i++) {
                int tem = R;
                R = Math.max (L + nums[i], R);
                L = tem;
            }
            return R;
        }
    }
}
