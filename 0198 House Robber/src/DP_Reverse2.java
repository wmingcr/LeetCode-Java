public class DP_Reverse2 {
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            int L = 0, R = 0;

            for(int i = n-1; i >= 0; i--){
                int tem = L;
                L = Math.max(nums[i] + R, L);
                R = tem;
            }

            return L;
        }
    }
}
