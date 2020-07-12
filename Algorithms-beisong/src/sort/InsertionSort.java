package sort;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        for (var i = 1; i < arr.length; i++) {
            var curr = arr[i];
            var j = i-1;
            for( ; j >= 0; j --){
                if(arr[j] > curr){
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = curr;
        }
    }

    public static void insertionSort2(int[] arr) {
        for (var i = 1; i < arr.length; i++) {
            var curr = arr[i];
            var j = i-1;
            while(j >= 0 && arr[j] > curr){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = curr;
        }
    }
}
