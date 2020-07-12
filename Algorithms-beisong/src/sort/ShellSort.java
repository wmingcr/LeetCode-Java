package sort;

public class ShellSort {

    public static void shellSort(int[] arr){
        int len = arr.length;
        for(int gap = len/2; gap > 0; gap /= 2){
            for(int i = gap; i < len; i ++){
                int j = i, curr = arr[i];
                while(j-gap >= 0 && arr[j-gap] > curr){
                    arr[j] = arr[j-gap];
                    j -= gap;
                }
                arr[j] = curr;
            }
        }
    }

}
