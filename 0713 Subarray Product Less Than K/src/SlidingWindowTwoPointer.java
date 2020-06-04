public class SlidingWindowTwoPointer {

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 6};
        System.out.println (new Solution ().numSubarrayProductLessThanK (arr, 100));
    }

    static class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            // corner case
            if(nums == null || nums.length == 0){
                return 0;
            }
            // get length
            int n = nums.length;
            // recording answers
            int ans = 0;
            // two pointers
            int l = 0, r = 0;
            double product = 1;
            while(r < n){
                product *= nums[r];

                while(product >= k && l <= r){
                    product /= nums[l];
                    l++;
                }
                if(product < k){
                    ans += r - l + 1;
                }
                r++;
            }
            return ans;
        }
    }
}
