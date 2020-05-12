class Solution {

    //nlgn, n
    public int lengthOfLIS(int[] nums) {
        //validity
        if(nums == null || nums.length == 0){
            return 0;
        }

        int len = nums.length;

        int[] tail = new int[len]; // recording lis

        tail[0] = nums[0];

        int end = 0;

        for(int i = 1; i < nums.length; i ++){

            if(nums[i] > tail[end]){
                end++;
                tail[end] = nums[i];
            } else {
                // find the element which is the first elements greater than nums[i]
                int idx = findIdxOfTheFirstGreater(tail, 0, end, nums[i]);
                tail[idx] = nums[i];
            }

        }

        return ++end;
    }

    private int findIdxOfTheFirstGreater(int[] tail, int lo, int hi, int target){

        while(lo < hi){

            int mid = lo + ((hi-lo)>>1);

            if(tail[mid] == target){
                //return lo; // get the wrong answer because of this line

                return mid;
            } else if (tail[mid] > target){
                hi = mid;
            } else{
                lo = mid+1;
            }
        }

        return lo;
    }


}