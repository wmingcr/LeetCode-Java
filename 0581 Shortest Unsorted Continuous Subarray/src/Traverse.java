public class Traverse {

    public static void main(String[] args) {
        int [] arr = {1,2,3,3,3};
        int ans = new Solution ().findUnsortedSubarray (arr);
        System.out.println (ans);
    }

    static class Solution {
        public int findUnsortedSubarray(int[] nums) {
            // corner case
            if(nums == null || nums.length == 0){
                return 0;
            }

            // get length
            int n = nums.length;
            // get the max and relative index
            int lmax = nums[0];
            int lidx = 0;

            // 找到左边拐点
            for(int i = 0; i < n; i ++){
                if(nums[i] > lmax){
                    lmax = nums[i];
                    lidx = i;
                }
                if(nums[i] < lmax){
                    break;
                }
            }

            // if(nums[lidx] == nums[n-1]){  1 2 3 3 3 || 1 2 3 4 5 || 1 2 3 2 3 3
            //     return 0;
            // }

            if(lidx == n-1){
                return 0;
            }

            int rmin = nums[lidx+1];

            for(int i = lidx+1; i < n; i ++){
                if(nums[i] < rmin){
                    rmin = nums[i];
                }
            }

            int l = 0;
            for(int i = 0; i <= lidx; i ++){
                if(nums[i] > rmin){
                    l = i;
                    break;
                }
            }

            int ridx = n-1;
            rmin = nums[ridx];
            for(int i = n-1; i >= lidx; i--){
                if(nums[i] > rmin){
                    break;
                }
                if(nums[i] < rmin){
                    rmin = nums[i];
                    ridx = i;
                }
            }

            lmax = nums[0];
            for(int i = 0; i <= ridx; i ++){
                if(lmax < nums[i]){
                    lmax = nums[i];
                }
            }

            int r = n-1;
            for(int i = n-1; i >= ridx; i --){
                if(nums[i] < lmax){
                    r = i;
                    break;
                }
            }

            return r-l+1;
        }
    }
}
