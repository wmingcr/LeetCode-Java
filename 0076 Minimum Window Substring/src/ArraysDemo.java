import java.util.Random;

public class ArraysDemo {

    public static void quickSort(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }
        sort(arr, 0, arr.length-1);
    }

    private static void sort(int[] arr, int from, int to){
        if(from < to){
            int idx = partition(arr, from, to);
            sort(arr, from, idx-1);
            sort(arr, idx+1, to);
        }
    }

    private static int partition(int[] arr, int left, int right){
        int pivotIdx = new Random ().nextInt (right-left) + 1 + left;
        int pivotVal = arr[pivotIdx];
        swap(arr, pivotIdx, right);
        int savedPosition = right;
        right--;

        while(left <= right){
            if(arr[left] <= pivotVal){
                left++;
            }else{
                swap(arr, left, right);
                right--;
            }
        }

        swap(arr, left, savedPosition);
        return left;
    }

    private static void swap(int[] arr, int a, int b){
        int te = arr[a];
        arr[a] = arr[b];
        arr[b] = te;
    }

}
