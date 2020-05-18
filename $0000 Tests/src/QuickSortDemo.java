import java.util.Random;

public class QuickSortDemo {

    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        sort (arr, 0, arr.length-1);
    }

    private void sort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int sortedIdx = partition (arr, lo, hi);
            sort(arr, lo, sortedIdx-1);
            sort(arr, sortedIdx+1, hi);
        }
    }

    private int partition(int[] arr, int lo, int hi) {

        int pivotIdx = new Random ().nextInt (hi - lo + 1) + lo;
        int pivotVal = arr[pivotIdx];
        int savedPosition = hi;
        swap (arr, pivotIdx, hi--);

        while(lo <= hi){
            if(arr[lo] <= pivotVal){
                lo++;
            } else {
                swap(arr, lo, hi--);
            }
        }
        swap(arr, lo, savedPosition);
        return lo;
    }

    private void swap(int[] arr, int a, int b) {
        int tem = arr[a];
        arr[a] = arr[b];
        arr[b] = tem;
    }
}
