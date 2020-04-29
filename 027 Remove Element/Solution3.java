class Solution {
    public int removeElement(int[] nums, int val) {
        //return twoPointers1(nums, val);
        return twoPointers2(nums, val);
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
