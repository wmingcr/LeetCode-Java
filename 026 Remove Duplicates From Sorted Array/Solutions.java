class Solution {
    public int removeDuplicates(int[] nums) {
        //check validity
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        /*
        //two pointers
        int left = 0;
        int right = 0;
        while(right < nums.length){
            if(nums[right] == nums[left]){
                right ++;
            }else{
                nums[++left] = nums[right++];
            }
        }
        */
        
        /*
        int i, j;
        for(i = 0, j = 1; j < nums.length && i < nums.length; ){
            if(nums[j] == nums[i]){
                j++;
            }else{
                nums[++i] = nums[j++];
            }
        }
        */
        
        //optimize for loop
        
        int len = 1;
        for(int i = 0, j = 1; j < nums.length; ){
            if(nums[j] == nums[i]){
                j++;continue;
            }
            if(i+1 != j){
                nums[i+1] = nums[j];
            }
            i++;j++;len++;
        }
        
        return len;
    }
}
