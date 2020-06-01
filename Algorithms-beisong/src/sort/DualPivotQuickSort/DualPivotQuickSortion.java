package sort.DualPivotQuickSort;

public class DualPivotQuickSortion {

    public static void sort(int[] arr){
        sort(arr, 0, arr.length);
    }

    private static void sort(int[] arr, int fromIndex, int toIndex){
        rangeCheck(arr.length, fromIndex, toIndex);
        dualPivotQuickSort(arr, fromIndex, toIndex-1, 3);
    }

    private static void dualPivotQuickSort(int[] arr, int left, int right, int div){
        int len = right - left;

        if(len < 27){
            for(int i = left+1; i <= right; i ++){
                for(int j = i; j > left && arr[j] < arr[j-1]; j--){
                    swap(arr, j, j-1);
                }
            }
            return;
        }

        int third = len/div;

        int m1 = left + third;
        int m2 = right - third;
        // left, m1, m2, right
        if(m1 <= left){
            m1 = left + 1;
        }
        if(m2 >= right){
            m2 = right - 1;
        }
        if(arr[m1] < arr[m2]){
            swap(arr, m1, left);
            swap(arr, m2, right);
        }
        // pivots
        int pivot1 = arr[left];
        int pivot2 = arr[right];

        // pointers
        int less = left + 1;
        int great = right - 1;

        // sorting
        for(int k = less; k <= great; k++){
            if(arr[k] < pivot1){
                swap(arr, k, less++);
            }
            else if (arr[k] > pivot2){
                while(k < great && arr[great] > pivot2){
                    great--;
                }
                swap(arr, k, great--);
                if(arr[k] < pivot1){
                    swap(arr, k, less++);
                }
            }
        }

        // swaps
        int dist = great - less;

        if(dist < 13){
            div++;
        }

        swap(arr, less - 1, left);
        swap(arr, great + 1, right);

        // subarrays
        dualPivotQuickSort (arr, left, less - 2, div);
        dualPivotQuickSort (arr, great + 2, right, div);

        if(dist > len - 13 && pivot1 != pivot2){
            for(int k = less; k <= great; k++){
                if(arr[k] == pivot1){
                    swap(arr, k, less++);
                }
                else if (arr[k] == pivot2) {
                    swap (arr, k, great--);
                    if(arr[k] == pivot1){
                        swap(arr, k, less++);
                    }
                }
            }
        }
        if(pivot1 < pivot2){
            dualPivotQuickSort (arr, less, great, div);
        }

    }

    private static void swap(int[] arr, int i, int j){
        int te = arr[i];
        arr[i] = arr[j];
        arr[j] = te;
    }

    private static void rangeCheck(int length, int fromIdx, int toIdx){
        if(fromIdx > toIdx){
            throw new IllegalArgumentException ("fromIdx > toIdx");
        }
        if(fromIdx < 0){
            throw new ArrayIndexOutOfBoundsException (fromIdx);
        }
        if(toIdx > length){
            throw new ArrayIndexOutOfBoundsException (toIdx);
        }
    }
}
