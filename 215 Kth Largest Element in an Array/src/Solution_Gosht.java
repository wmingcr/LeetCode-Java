import java.util.Random;

public class Solution_Gosht {

    //quickSort

    //there is something wrong for int[] arr = {3,2,1,5,6,4}; the ans is 0 or 5 randomly

    //recording ans
    long ans;

    public int findKthLargest(int[] nums, int k) {
        //validity
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length){
            return -1;
        }

        //quicksort
        quickSort(nums, 0, nums.length-1, k);

        return (int)ans;
    }

    private void quickSort(int[] nums, int lo, int hi, int k){
        if(lo < hi){
            int idx = partition(nums, lo, hi, k);
            if(ans >= Integer.MIN_VALUE){ // found the ans
                return;
            }
            //didnt think about only sort part of the array to find nums.length - k
            quickSort(nums, lo, idx-1, k);
            quickSort(nums, idx+1, hi, k);
        }
    }

    private int partition(int[] nums, int lo, int hi, int k){

        Random random = new Random();
        int pivotIdx = random.nextInt(hi - lo + 1) + lo; // random idx
        int pivotVal = nums[pivotIdx]; // value
        int savedPosition = hi; // save it  in case hi changed
        swap(nums, pivotIdx, hi--); // save the chosen value

        while(lo <= hi){
            if(nums[lo] <= pivotVal){ // just increase lo,
                lo++;
            }else{
                swap(nums, lo, hi--); // do swap, then hi--, since nums[hi] is greater than pivot
            }
        }

        swap(nums, lo, savedPosition); // rearrange the right position for pivot

        if(lo == nums.length-k){
            ans = nums[lo];
        }

        return lo;
    }

    private void swap(int[] nums, int a, int b){
        int te = nums[a];
        nums[a] = nums[b];
        nums[b] = te;
    }
}
