class Solution {
    public boolean checkPossibility(int[] nums) {
        if(nums == null){
            return false;
        }
        int count = 0;
        for(int i = 0, j = i + 1; j < nums.length; i++, j++){
            if(nums[i] > nums[j]){
                count++;
                if(count >= 2){
                    return false;
                }
                if(i - 1 < 0){
                    nums[i] = nums[j];
                }else if(nums[i-1] <= nums[j]){
                    nums[i] = nums[j];
                }else{
                    nums[j] = nums[i];
                }
            }
        }
        return true;
    }
}

/* 
T, O(n); S, O(1). 
*/
