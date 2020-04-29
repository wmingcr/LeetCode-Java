//简洁，明了
class Solution {
    public int searchInsert(int[] nums, int target) {
        //check validity
        if(nums == null){
            return -1;
        }
        if(nums.length == 0){
            return 0;
        }
        //binary search
        int left = 0;
        for(int right = nums.length - 1, mid = left + ((right - left)>>1); left <= right; mid = left + ((right - left)>>1)){
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
}
