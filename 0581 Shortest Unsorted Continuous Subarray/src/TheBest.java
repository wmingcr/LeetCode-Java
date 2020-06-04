public class TheBest {

    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            // corner case
            if(nums == null || nums.length == 0){
                return 0;
            }
            // get length
            int n = nums.length;
            // ans, recording boundaries
            int l = n, r = -1;
            // recording whether we have found a curve
            boolean found = false;
            // if we have a curve, then record the min value on right side
            int rmin = Integer.MAX_VALUE;

            for(int i = 1; i < n; i ++){
                if(found == false){
                    if(nums[i-1] > nums[i]){
                        found = true;
                        rmin = nums[i];
                    }
                } else {
                    if(nums[i] < rmin){
                        rmin = nums[i];
                    }
                }
            }

            if(found == false){
                return 0;
            }

            for(int i = 0; i < n; i ++){
                if(nums[i] > rmin){
                    l = i;
                    break;
                }
            }
            found = false;
            int lmax = Integer.MIN_VALUE;
            for(int i = n-2; i >= 0; i--){
                if(found == false){
                    if(nums[i] > nums[i+1]){
                        found = true;
                        lmax = nums[i];
                    }
                } else {
                    if(nums[i] > lmax){
                        lmax = nums[i];
                    }
                }
            }
            for(int i = n-1; i >= 0; i--){
                if(nums[i] < lmax){
                    r = i;
                    break;
                }
            }
            return r-l+1;
        }
    }
}
