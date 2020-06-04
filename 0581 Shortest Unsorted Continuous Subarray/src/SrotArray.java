import java.util.Arrays;

public class SrotArray {

    // faster

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
            // for this method, we have to sort the array
            int[] brr = nums.clone();
            Arrays.sort(brr);

            for(int i = 0; i < n; i ++){
                if(brr[i] != nums[i]){
                    l = Math.min(l, i);
                    r = Math.max(r, i);
                }
            }

            return r - l < 0 ? 0 : r-l+1;
        }
    }
}
