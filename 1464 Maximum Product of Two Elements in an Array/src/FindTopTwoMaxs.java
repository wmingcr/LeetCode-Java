public class FindTopTwoMaxs {

    class Solution {
        public int maxProduct(int[] nums) {
            // validity
            if(nums == null || nums.length == 0){
                return 0;
            }

            int max1 = 0;
            for(int i = 0; i < nums.length; i ++){
                if(nums[i] > nums[max1]){
                    max1 = i;
                }
            }
            int max2 = max1 == 0 ? 1 : 0;
            for(int i = 0; i < nums.length; i ++){
                if(nums[i] > nums[max2] && i != max1){
                    max2 = i;
                }
            }
            return (nums[max1] - 1) * (nums[max2] - 1);
        }
    }
}
