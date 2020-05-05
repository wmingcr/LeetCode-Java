class Solution {
    public boolean search(int[] nums, int target) {
        //validity
        if(nums == null || nums.length == 0){
            return false;
        }
        
        //binary search
        int left = 0, right = nums.length-1;
        while(left <= right){
            
            //mid point
            int mid = left + ((right-left)>>1);
            
            //found target
            if(nums[mid] == target){
                return true;
            }
            
            //remove duplicates
            if(nums[left] == nums[mid]){
                left++; // 牵一发，动全身，当left发生变化，mid也会发生变化，所以continue循环继续. 不能使用while循环在这里
                continue;
            }
            
            if(nums[left] < nums[mid]){ // left side is sorted
                if(nums[left] <= target && target < nums[mid]){ // target is in this sorted part
                    right = mid - 1;
                }else{ // else, target is here
                    left = mid + 1;
                }
            }else{ // right side is sorted
                if(nums[mid] < target && target <= nums[right]){//target is in sorted part
                    left = mid + 1;
                }else{ // else, target is in this part
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
