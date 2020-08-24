public class DPGood {
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }

            int L = nums[0], R = Math.max (nums[0], nums[1]);
            for (int i = 2; i < n; i++) {
                int tem = R;
                R = Math.max (L + nums[i], R);
                L = tem;
            }

            return R;
        }
    }
}
