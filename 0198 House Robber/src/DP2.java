public class DP2 {
    class Solution {
        public int rob(int[] nums) {
            int p = 0, L = 0, R = 0, n = nums.length;

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    int tem = L;
                    L = Math.max (L, p) + nums[i];
                    p = tem;
                } else {
                    int tem = R;
                    R = Math.max (R, p) + nums[i];
                    p = tem;
                }
            }

            return Math.max (L, R);
        }
    }
}
