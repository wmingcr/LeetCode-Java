//find the index of the target first, then do binary search to both left and right side 

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftBound = -1, rightBound = -1;
        
        //validity
        if(nums == null || nums.length == 0){
            return new int [] {leftBound, rightBound};
        }
        
        //initialization
        int left = 0, right = nums.length-1;
        
        //binary search
        while(left <= right){
            
            //initialize mid point
            int mid = left + ((right-left)>>1);
            
            if(nums[mid] == target){ // find the target
                
                leftBound = findLeftBound(nums, left, mid, target); // continue to find left bound
                rightBound = findRightBound(nums, mid, right, target); // continue to find right bound
                break;
                
            }else if (nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return new int[] {leftBound, rightBound};
    }
    
    private int findLeftBound(int[] nums, int left, int right, int target){
        //continue to do binary search
        while(left <= right){
            
            //mid point
            int mid = left + ((right-left)>>1);
            
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
    
    private int findRightBound(int[] nums, int left, int right, int target){
        //continue to do binary search
        while(left <= right){
            
            //mid point
            int mid = left + ((right-left)>>1);
            
            if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return right;
    }
}
