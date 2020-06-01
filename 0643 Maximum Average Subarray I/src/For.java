public class For {

    public static void main(String[] args) {
        int[] arr = {1,12,-5,-6,50,3};
        System.out.println (new Solution().findMaxAverage (arr, 4));
    }

    static class Solution {
        public double findMaxAverage(int[] nums, int k) {

            // validity
            if(nums == null || nums.length == 0){
                return 0.0;
            }

            double sum = 0;

            int n = nums.length;

            for(int i = 0; i < k; i ++){
                sum += nums[i];
            }

            double ave = sum / k;

            int left = 0;
            int right = k;

            while(right < n){

                sum += nums[right++];
                sum -= nums[left++];

                double newAve = sum / k;
                // there is no need to update ave every time
                if(newAve > ave){
                    ave = newAve;
                }

            }

            return ave;
        }
    }
}
