class Solution {
    public int findMin(int[] nums) {
        // validity
        if(nums == null || nums.length == 0){
            return -1;
        }

        //There is no need to do corner case, since change the right pointer would cover this corner case
        //corner case
//        if(nums[0] < nums[nums.length-1]){
//            return nums[0];
//        }

        // two pointers
        int lo = 0, hi = nums.length-1;

        // binary search
        while(lo < hi){

            // mid
            int mid = (lo + hi)>>>1;

            /**
             这个地方一定要跟right比较，跟left比较的时候，假如mid==left，进行left++, 有可能把数组变成了一个完全升序排列的数组。
             */

            if(nums[mid] < nums[hi]){
                hi = mid;
            } else if (nums[mid] == nums[hi]){
                hi--;
            } else {
                lo = mid + 1;
            }

        }

        return nums[lo];
    }
}