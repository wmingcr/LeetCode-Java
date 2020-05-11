import java.util.Random;

class Solution_QuickSort {

    public int minMoves2(int[] nums) {

        //Ghost
        //要么有结果，要么死循环


        //validity
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // the index of median
        int medianIdx = nums.length / 2;

        //sorting part of the array to get the median
        int median = quickSort (nums, 0, nums.length - 1, medianIdx);

        int steps = 0;

        for (int i = 0; i < nums.length; i++) {
            steps += Math.abs (nums[i] - median);
        }

        return steps;
    }

    //do part quickSort to find kth element which is the median of array
    private int quickSort(int[] nums, int lo, int hi, int k) {

        if (lo >= hi) {
            return nums[lo];
        }

        while (true) {

            //find the element right with index idx
            int idx = partition (nums, lo, hi);

            if (idx == k) {
                return nums[idx]; // got it
            } else if (idx < k) {
                lo = idx + 1; // right side
            } else {
                hi = idx - 1; // left side
            }
        }

    }

    private int partition(int[] nums, int lo, int hi) {

        // got a random pivot Index
        int pivotIdx = new Random ().nextInt (hi - lo + 1) + lo;

        // pivot value
        int pivotVal = nums[pivotIdx];

        //save index of hi
        int savedPosition = hi;

        //swap the pivot to hi, incase it will be changed
        swap (nums, pivotIdx, hi--);

        while (lo <= hi) {
            if (nums[lo] <= pivotVal) {
                lo++; // left smaller element in the left side
            } else {
                swap (nums, lo, hi--); // swap greater value to right side
            }
        }

        // change pivot to its right position
        swap (nums, lo, savedPosition);

        // the index with sorted element
        return lo;
    }

    private void swap(int[] nums, int a, int b) {
        int te = nums[a];
        nums[a] = nums[b];
        nums[b] = te;
    }
}