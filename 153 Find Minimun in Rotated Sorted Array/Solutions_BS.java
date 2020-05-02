//some dif with official answer
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solution/
class Solution {
    public int findMin(int[] nums) {
        //if the array is null or contains no element
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        //initializing the answer
        int ans = nums[0];
        
        //special condition, 
        //e.g. 1 < 2 < 3 < 4 < 5 < 8, which means array is alreay in an ascending order
        if(nums[0] < nums[nums.length-1]){//no "=", eg. 4, 5, 6, 1, 2, 3, 4
            return ans;
        }
        
        //binary search, initializing two pointers
        int left = 0, right = nums.length-1;
        while(left < right){// with "=" ?
            
            //mid point
            int mid = left + ((right-left)>>1);
            
            //found minimum element
            if(mid > 0 && nums[mid] < nums[mid-1]){
                ans = nums[mid];
                break;
            }
            
            //found minimum element
            if(mid < nums.length-1 && nums[mid] > nums[mid+1]){
                ans = nums[mid+1];
                break;
            }
            
            if(nums[mid] > nums[left]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
            
        }
        return ans;
    }
}
