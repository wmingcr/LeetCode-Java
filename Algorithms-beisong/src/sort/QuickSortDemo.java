package sort;

import java.util.Random;

public class QuickSortDemo {
    public static void sort(int[] arr){
        sort(arr, 0, arr.length-1);
    }

    private static void sort(int[] arr, int lo, int hi){
        if(lo < hi){
            int pivot = partition(arr, lo, hi);
            sort(arr, lo, pivot-1);
            sort(arr, pivot+1, hi);
        }
    }

    private static int partition(int[]arr, int lo, int hi){
        Random random = new Random();
        int pivotIdx = random.nextInt (hi - lo + 1) + lo;
        int pivotValue = arr[pivotIdx];
        int savedPosition = hi;
        swap(arr, hi, pivotIdx);
        hi--;
        while(lo <= hi){
            if(arr[lo] <= pivotValue){
                lo++;
            } else {
                swap(arr, hi, lo);
                hi--;
            }
        }
        swap(arr, lo, savedPosition);
        return lo;
    }

    private static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
