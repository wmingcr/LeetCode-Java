class Solution {
    public int search(int[] nums, int target) {
        //validity
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        //binary search
        for(int left = 0, right = nums.length-1; left <= right; ){
            
            //mid point
            int mid = left + ((right-left)>>1);
            
            //found the target
            if(target == nums[mid]){
                return mid;
            }
            
            //always do binary search in the sorted part
            if(nums[left] <= nums[mid]){//left side is in ascending order
                if(nums[left] <= target && target < nums[mid]){//during in the sorted part
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[right]){//still in the sorted part
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
