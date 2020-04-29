class Solution {
    public int removeElement(int[] nums, int val) {
        //return twoPointers1(nums, val);
        //return twoPointers2(nums, val);
        return twoPointers3(nums, val);
    }
    
    /*
    the second method go through the array 2n times
    however, we can use this one to reduce it to n times
    */
    private int twoPointers3(int [] nums, int val){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = 0; 
        for(int i = 0, j = nums.length - 1; i <= j; ){
            if(nums[i] == val){
                nums[i] = nums[j];
                j--;
            }else{
                len++;i++;
            }
        }
        return len;
    }
    
    
    /*
    for twoPointers1, if array is like no element equals val, there will be 
    n-1 times of assignment, let's avoid this one;
    */
    private int twoPointers2(int[] nums, int val){
        //check validity
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = 0;
        for(int i = -1, j = 0; j < nums.length; j++){
            if(nums[j] == val){
                continue;
            }
            if(i+1 != j){
                nums[i+1] = nums[j];
            }
            i++;
            len++;
        }
        return len;
    }
    
    
    /*
    two pointers, slower and faster,
    */
    private int twoPointers1(int[] nums, int val){
        //check validity
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = 0;
        for(int i = -1, j = 0; j < nums.length; j ++){
            if(nums[j] != val){
                nums[++i] = nums[j];
                len ++;
            }
        }
        return len;
    }
}
