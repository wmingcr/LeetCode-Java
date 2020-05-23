import java.util.Arrays;

public class CountingSort {

    class Solution {
        public void sortColors(int[] nums) {
            // validity
            if(nums == null || nums.length <= 1){
                return;
            }

            // get length
            int n = nums.length;

            // do counting sort
            int[] arr = new int[3];

            // pass nums, to count 0s, 1s, 2s,
            for(int i = 0; i < n; i ++){
                if(nums[i] == 0){
                    arr[0]++;
                } else if (nums[i] == 1){
                    arr[1]++;
                } else {
                    arr[2]++;
                }
            }
            // update frequency
            arr[1] += arr[0];
            arr[2] += arr[1];
            int [] brr = Arrays.copyOf(nums, n);
//            System.out.println(Arrays.toString(nums));
//            System.out.println(Arrays.toString(brr));
//            System.out.println(Arrays.toString(arr));
            // update nums
            for(int i = n-1; i >= 0; i--){
                nums[--arr[brr[i] - 0]] = brr[i];
            }
        }
    }
}
