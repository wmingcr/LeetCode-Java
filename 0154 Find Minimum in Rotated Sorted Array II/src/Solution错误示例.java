class Solution错误示例 {

    public int findMin(int[] nums) {
        // validity
        if(nums == null || nums.length == 0){
            return -1;
        }

        //corner case
        if(nums[0] < nums[nums.length-1]){
            return nums[0];
        }

        // two pointers
        int lo = 0, hi = nums.length-1;

        // binary search
        while(lo < hi){

            // mid
            int mid = (lo + hi)>>>1;

            /**
             这个地方一定要跟right比较，跟left比较的时候，假如mid==left，进行left++, 有可能把数组变成了一个完全升序排列的数组。
             */

            if(nums[mid] > nums[lo]){ // left side is in ascending order
                lo = mid + 1;
            } else if (nums[mid] == nums[lo]){
                lo++;
            } else {
                hi = mid;
            }

        }

        return nums[lo];
    }
}