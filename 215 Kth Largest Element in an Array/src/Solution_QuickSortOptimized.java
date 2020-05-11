import java.util.Random;

class Solution_QuickSortOptimized {
    public int findKthLargest(int[] nums, int k) {
        //validity
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length){
            return -1;
        }

        int lo = 0, hi = nums.length-1, target = nums.length-k;

        while(true){

            int idx = partition(nums, lo, hi); // sorted element with index idx,

            if(idx == target){
                return nums[idx]; // found the Kth largest element
            } else if (idx < target){
                lo = idx + 1; // right side
            } else {
                hi = idx - 1; // left side
            }
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


