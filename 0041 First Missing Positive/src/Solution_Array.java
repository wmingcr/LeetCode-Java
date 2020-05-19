public class Solution_Array {

    class Solution {
        public int firstMissingPositive(int[] nums) {
            if(nums == null || nums.length == 0){
                return 1;
            }
            int n = nums.length;

            int[] ans = new int[n+1];

            for(int num : nums){
                if(num > 0 && num <= n){
                    ans[num]++;
                }
            }
            int i = 1;
            for( ; i <= n; i++){
                if(ans[i] == 0){
                    break;
                }
            }
            return i;
        }
    }
}
