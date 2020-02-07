class Solution {
    public boolean checkPossibility(int[] nums) {
        //robustness
        if(nums == null){
            return false;
        }
        int count = 0;
        for(int i = 0, j = i + 1; j < nums.length; i++, j++){
            if(nums[i] > nums[j]){
                //record how many times we need to modify
                count++;
                //if it's greater than two, which means we have to do "modify" two times, which is not allowed. 
                if(count >= 2){
                    return false;
                }
                //i is the first ellement
                if(i - 1 < 0){
                    nums[i] = nums[j];
                }else if(nums[i-1] <= nums[j]){ //compare two values before, after i,
                    nums[i] = nums[j];
                }else{
                    nums[j] = nums[i];
                }
            }
        }
        //nothing goes wrong, then it's true for this array. 
        return true;
    }
}

/* 
T, O(n); S, O(1). 
*/
