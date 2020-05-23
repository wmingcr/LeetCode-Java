public class Official_OnePass {


    class Solution {
        public void sortColors(int[] nums) {
            // validity
            if(nums == null || nums.length <= 1){
                return ;
            }

            // all in [0, p0] = 0
            // all in (p0+1, p2-1) = 1
            // all in (p2, len - 1] = 2

            // https://leetcode-cn.com/problems/sort-colors/solution/kuai-su-pai-xu-partition-guo-cheng-she-ji-xun-huan/


            int n = nums.length;
            int p0 = 0, p2 = n - 1; // i for 0s, j for 2s
            int curr = 0; // curr

            while(curr <= p2){
                if(nums[curr] == 0){
                    swap(nums, p0++, curr++);
                } else if (nums[curr] == 2){
                    swap(nums, p2--, curr);
                } else {
                    curr++;
                }
            }
        }

        private void swap(int[] nums, int a, int b){
            int te = nums[a];
            nums[a] = nums[b];
            nums[b] = te;
        }
    }
}
