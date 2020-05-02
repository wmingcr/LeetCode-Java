class Solution {
    public int findMin(int[] nums) {
        //if the array is null or contains no element
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        //initializing two pointers
        int left = 0, right = nums.length-1;
        
        //if the array already in ascending order, eg. 1, 2, 3, 4, 5
        if(nums[left] < nums[right]){
            return nums[left];
        }
        
        //binary search
        while(left < right){
            
            //mid point
            int mid = left + ((right-left)>>1);
            
            if(nums[mid] < nums[right]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return nums[left];
    }
}
