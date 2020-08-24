public class DP_Best {
    class Solution {
        public int maxProduct(int[] nums) {

            int imin = nums[0], imax = nums[0];
            int res = imax, n = nums.length;

            for (int i = 1; i < n; i++) {
                if (nums[i] < 0) {
                    int tem = imin;
                    imin = imax;
                    imax = tem;
                }

                imin = Math.min (nums[i], imin * nums[i]);
                imax = Math.max (nums[i], imax * nums[i]);

                res = Math.max (res, imax);
            }

            return res;
        }
    }
}
