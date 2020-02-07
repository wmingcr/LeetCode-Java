class Solution {
    public int removeElement(int[] nums, int val) {
        //check validity of array
        if(nums == null){
            return -1;
        }
        if(nums.length == 0){
            return 0;
        }
        //recording lenght of new array
        int count = nums.length;
        //two pointers from each side,
        for(int left = 0, right = count - 1; left <= right; ){
            if(nums[left] == val){
                swap(nums, left, right);
                count --;
                right --;
            }else{
                left++;
            }
        }
        return count;
    }
    private void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

