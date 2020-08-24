import java.util.Arrays;

public class Nlogn {
    class Solution {
        public int longestConsecutive(int[] nums) {
            // corner case
            if(nums == null || nums.length == 0){
                return 0;
            }

            Arrays.sort(nums);

            int curr = nums[0], res = 1, tep = 1;

            for(int i = 1; i < nums.length; i ++){
                if(nums[i] == curr){
                    continue;
                }

                if(nums[i] == curr + 1){
                    curr = nums[i];
                    tep ++;
                    res = Math.max(res, tep);
                } else {
                    curr = nums[i];
                    tep = 1;
                }
            }

            return res;
        }
    }
}
