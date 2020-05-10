import java.util.Arrays;

public class Solution_Sortion {

    //not the best solution,
    //TC, O(nlgn)
    //SC, O(lgn)   <----- from Arrays.sort, quickSort

    public int findKthLargest(int[] nums, int k) {
        //validity
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length){
            return -1;
        }

        Arrays.sort(nums);

        return nums[nums.length - k];
    }


}
