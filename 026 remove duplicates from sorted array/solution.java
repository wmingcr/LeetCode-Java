class Solution {
    public int removeDuplicates(int[] nums) {
        //you don't throw exceptions, otherwise it wont work
        
        //robustness
        if(nums == null){
            return -1;
        }
        if(nums.length <= 0){
            return 0;
        }
        //recording length of "new" array
        int len = 1;
        //using two pointers
        for(int i = 0, j = i+1; j < nums.length; j++){
            if(nums[i] == nums[j]){
                continue;
            }
            /*nums[i+1] = nums[j];*/
            if(i+1 != j){
                nums[i+1] = nums[j];
            }
            i++;
            len++;
        }
        return len;
    }
}
