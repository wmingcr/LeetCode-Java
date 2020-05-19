public class Solution_Official {

    class Solution {
        public int firstMissingPositive(int[] nums) {
            // validity
            if(nums == null || nums.length == 0){
                return 1;
            }

            // get length
            int n = nums.length;
            // find whether 1 is existing in there
            int k = 0;
            for( ; k < n; k ++){
                if(nums[k] == 1){
                    break;
                }
            }
            // 1 doesnt exist in nums
            if(k == n){
                return 1;
            }
            // change all elements less or equal to 0, or greater than n, to 1
            for(int i = 0; i < n; i++){
                if(nums[i] <= 0 || nums[i] > n){
                    nums[i] = 1;
                }
            }
            // change element to its relative index to negative numbers
            for(int i = 0; i < n; i ++){
                int a = Math.abs(nums[i]);
                if(a == n){
                    nums[0] = -Math.abs(nums[0]);
                } else {
                    nums[a] = -Math.abs(nums[a]);
                }
            }
            // find the first missing positive number which is positive
            for(int i = 2; i < n; i ++){
                if(nums[i] > 0){
                    return i;
                }
            }
            // check n
            if(nums[0] > 0){
                return n;
            }

            return n+1;

        }
    }
}
