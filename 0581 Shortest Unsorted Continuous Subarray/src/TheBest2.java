public class TheBest2 {



    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            // brute force
            // corner case
            if(nums == null || nums.length == 0){
                return 0;
            }
            // get length
            int n = nums.length;
            // boundaries for subarray
            int l = n, r = -1;
            // find the curve point
            for(int i = 1; i < n; i ++){
                if(nums[i-1] > nums[i]){
                    l = i-1;
                    break;
                }
            }
            // eg, 1 2 3 4 5 ascending order
            if(l == n){
                return 0;
            }
            // find right boundary of curve
            for(int i = n-1; i > 0; i --){
                if(nums[i-1] > nums[i]){
                    r = i;
                    break;
                }
            }
            // find max and min during the bounday
            int min = nums[l];
            int max = nums[l];
            for(int i = l; i <= r; i++){
                if(nums[i] > max){
                    max = nums[i];
                }
                if(nums[i] < min){
                    min = nums[i];
                }
            }
            // left boundary, the first element that is greater than min
            for(int i = 0; i < n; i ++){
                if(nums[i] > min){
                    l = i;
                    break;
                }
            }
            // right boundary, the first element that is less than max
            for(int i = n-1; i >= 0; i--){
                if(nums[i] < max){
                    r = i;
                    break;
                }
            }
            return r-l+1;
        }
    }
}
