public class BruteForce {

    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            if (nums == null || nums.length == 0 || lower > upper) {
                return 0;
            }

            int res = 0, n = nums.length;

            for (int i = 0; i < n; i++) {
                long sum = 0;
                for (int j = i; j < n; j++) {
                    sum += nums[j];
                    if (lower <= sum && sum <= upper) {
                        res++;
                    }
                }
            }

            return res;
        }
    }
}
