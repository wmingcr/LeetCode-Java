class Solution {
    public int findPeakElement(int[] nums) {
        //validity
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        //coner cases
        if(nums.length == 1){
            return 0;
        }
        
        //peak is the first one 
        if(nums[0] > nums[1]){
            return 0;
        }
        
        //peak is the last one
        int n = nums.length;
        if(nums[n-1] > nums[n-2]){
            return n-1;
        }
        
        //initialization
        int left = 0, right = n - 1;
        
        //bianry search
        while(left <= right){
            
            //mid point
            int mid = left + ((right-left)>>1);
            
//             if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
//                 return mid;
//             }
            
            //如果实在不好找中间的结束条件，那就把结束条件让left, right带出去。
            
            if(nums[mid] < nums[mid+1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        return left;
    }
}
