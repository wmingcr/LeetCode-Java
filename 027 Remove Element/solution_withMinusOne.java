class Solution {
    public int removeElement(int[] nums, int val) {
        //check validity of array
        if(nums == null){
            return -1;
        }
        if(nums.length == 0){
            return 0;
        }
        //record length of new array
        int count = 0;
        //two pointers
        //with left is -1, problem might be easier
        for(int left = -1, right = 0; right < nums.length; right ++){
            if(nums[right] != val){
                count++;
                //check if they are pointing to the same value
                if(left+1 != right){
                  nums[++left] = nums[right];
                }
            }
        }
        return count;
    }
}
