public class DP {
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }

            int L1 = nums[0], R1 = Math.max (nums[0], nums[1]);

            if (n == 2) {
                return R1;
            }

            for (int i = 2; i < n - 1; i++) {
                int tem = R1;
                R1 = Math.max (R1, L1 + nums[i]);
                L1 = tem;
            }

            int L2 = nums[1], R2 = Math.max (nums[1], nums[2]);
            for (int i = 3; i < n; i++) {
                int tem = R2;
                R2 = Math.max (R2, L2 + nums[i]);
                L2 = tem;
            }

            return Math.max (R1, R2);
        }
    }
}
