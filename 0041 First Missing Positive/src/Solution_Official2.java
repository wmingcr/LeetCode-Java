public class Solution_Official2 {

    // this method is a little slower than official answer, maybe the reason is that
    // there are many swaps during processing.

    class Solution {
        public int firstMissingPositive(int[] nums) {
            // validity
            if(nums == null || nums.length == 0){
                return 1;
            }

            // get length
            int n = nums.length;
            // rearrange nums[i] to the index (nums[i]-1)
            for(int i = 0; i < n; i ++){
                while(nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]){
                    swap(nums, i, nums[i] - 1);
                }
            }
            // find the missing positive
            for(int i = 0; i < n; i++){
                if(nums[i] != i + 1){
                    return i + 1;
                }
            }
            return n + 1;
        }

        private void swap(int[] nums, int a, int b){
            int te = nums[a];
            nums[a] = nums[b];
            nums[b] = te;
        }
    }
}
