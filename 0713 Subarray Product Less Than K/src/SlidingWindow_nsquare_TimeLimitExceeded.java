public class SlidingWindow_nsquare_TimeLimitExceeded {

    // there is no error, just time limit exceeded
    // which means, this is not the efficient way of solving this problem

    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            // corner case
            if(nums == null || nums.length == 0){
                return 0;
            }
            // get length
            int n = nums.length;
            // recording answers
            int ans = 0;
            for(int i = 1; i <= n; i ++){
                // 用来记录乘积
                double product = 1;
                // 记录已经乘的个数
                int subcount = 0;
                for(int j = 0; j < n; j ++){
                    product *= nums[j];
                    subcount++;
                    if(subcount == i){
                        if(product < k){
                            ans++;
                        }
                    }
                    if(subcount >= i){
                        product /= nums[j-i+1];
                        subcount--;
                    }
                }
            }
            return ans;
        }
    }
}
