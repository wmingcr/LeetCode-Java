public class Solution_BinarySearch {
    // liweiwei1419
    class Solution {
        public int findDuplicate(int[] nums) {
            // 1. 求和，一旦涉及求和、乘积，类型溢出
            // 2. 证明：如果最大值<=n,最小值>=1，则n+1个数一定有重复
            if(nums == null){
                return 0;
            }
            // two pointers
            int lo = 1, hi = nums.length-1;
            // binary search
            while(lo < hi){
                // mid point
                int mid = lo + ((hi - lo) >> 1);
                // number of elements which is smaller or equal to nums[mid]
                int total = 0;
                for(int num : nums){
                    if(num <= mid){
                        total++;
                    }
                }
                // right side has duplicates
                if(total <= mid){
                    lo = mid + 1;
                } else { // left side has duplicates
                    hi = mid;
                }
            }
            return lo;
        }
    }
}
