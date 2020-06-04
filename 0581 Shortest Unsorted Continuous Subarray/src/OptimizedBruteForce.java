public class OptimizedBruteForce {

    // after break, saved a lot of time

    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            // brute force
            // corner case
            if(nums == null || nums.length == 0){
                return 0;
            }
            // get length
            int n = nums.length;
            // left boundary
            int l = -1;
            outer: for(int i = 0; i < n; i ++){
                for(int j = i+1; j < n; j ++){
                    if(nums[j] < nums[i]){
                        l = i;
                        break outer;
                    }
                }
            }
            if(l == -1){
                return 0;
            }
            int r = n;
            outer: for(int i = n-1; i >= 0; i--){
                for(int j = i-1; j >= 0; j--){
                    if(nums[j] > nums[i]){
                        r = i;
                        break outer;
                    }
                }
            }
            return r-l+1;
        }
    }
}
