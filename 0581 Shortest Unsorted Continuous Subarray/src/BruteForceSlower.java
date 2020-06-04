public class BruteForceSlower {


    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            // brute force
            // corner case
            if(nums == null || nums.length == 0){
                return 0;
            }
            // get length
            int n = nums.length;
            int l = n, r = 0;

            for(int i = 0; i < n-1; i ++){
                for(int j = i+1; j < n; j ++){
                    if(nums[j] < nums[i]){
                        l = Math.min(l, i);
                        r = Math.max(r, j);
                    }
                }
            }
            return r - l > 0 ? r-l+1 : 0;
        }
    }
}
