class Solution {
    public int searchInsert(int[] nums, int target) {
        //first thought, binary search
        if(nums == null){
            return -1;
        }
        if(nums.length == 0){
            return 0;
        }
        //binary search,
        int left = 0, right = nums.length;
        for(int mid = (left+right)/2; left < nums.length && left<=right && right >=0; mid = (left+right)/2){
            if(target == nums[mid]){
                return mid;
            }else if(target < nums[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        //target is less than any elements
        if(right < 0){
            return 0;
        }else if(left >= nums.length){//target is greater than any one
            return nums.length;
        }else{
            return left;//didn't find it, but it's in the range
        }
    }
}
