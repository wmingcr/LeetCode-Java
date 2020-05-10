import java.util.Random;

class Solution_QuickSort {
    public int findKthLargest(int[] nums, int k) {
        //validity
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length){
            return -1;
        }

        return quickSort(nums, 0, nums.length-1, k);
    }

    private int quickSort(int[] nums, int lo, int hi, int k){
        if(lo >= hi){
            return nums[lo];
        }

        int idx = partition(nums, lo, hi);

        if(idx == nums.length-k){
            return nums[idx];
        }else if (idx < nums.length-k){
            return quickSort(nums, idx+1, hi, k);
        }else {
            return quickSort(nums, lo, idx-1, k);
        }
    }

    private int partition(int[] nums, int lo, int hi){

        Random random = new Random();
        int pivotIdx = random.nextInt(hi-lo+1) + lo;
        int pivotVal = nums[pivotIdx];
        int savedPosition = hi;
        swap(nums, pivotIdx, hi--);

        while(lo <= hi){
            if(nums[lo] <= pivotVal){
                lo++;
            }else {
                swap(nums, lo, hi--);
            }
        }

        swap(nums, lo, savedPosition);

        return lo;
    }

    private void swap(int[] arr, int a, int b){
        int te = arr[a];
        arr[a] = arr[b];
        arr[b] = te;
    }

}

