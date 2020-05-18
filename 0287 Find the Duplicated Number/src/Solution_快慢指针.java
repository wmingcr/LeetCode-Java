public class Solution_快慢指针 {

    class Solution {
        public int findDuplicate(int[] nums) {
            // validity
            if(nums == null || nums.length == 0){
                return -1;
            }

            // 快慢指针的证明：official answer,
            // see: https://leetcode.com/problems/find-the-duplicate-number/solution/

            // initialization, since 0 is not between 1 ~ n, so 0 is not included
            // explanation see approach#3:
            // https://leetcode-cn.com/problems/find-the-duplicate-number/solution/xun-zhao-zhong-fu-shu-by-leetcode/

            int t = nums[0];
            int h = nums[0];
            // until they meet
            do{
                t = nums[t];
                h = nums[nums[h]];
            } while(t != h);
            // initialization
            t = nums[0];
            // find the entrance
            while(t != h){
                t = nums[t];
                h = nums[h];
            }
            return t;
        }
    }

}
