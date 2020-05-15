package sort.QuickSort;

import java.util.Random;

public class QuickSort_RandomPivot {

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int idxSorted = partition(arr, lo, hi);
            quickSort (arr, lo, idxSorted-1);
            quickSort (arr, idxSorted+1, hi);
        }
    }

    public static int partition(int[] arr, int lo, int hi){

        Random random = new Random ();
        int pivotIdx = random.nextInt (hi - lo + 1) + lo;
        int pivotVal = arr[pivotIdx];
        int savedPosition = hi;
        swap(arr, pivotIdx, hi--);

        while(lo <= hi){
            if(arr[lo] <= pivotVal){
                lo++;
            }else{
                swap(arr, lo, hi--);
            }
        }

        swap(arr, lo, savedPosition);

        return lo;
    }

    public static void swap(int[] arr, int a, int b){
        int te = arr[a];
        arr[a] = arr[b];
        arr[b] = te;
    }
}
