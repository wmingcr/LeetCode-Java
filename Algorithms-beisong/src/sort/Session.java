package sort;

import java.util.Arrays;

public class Session {

    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8, 0};
        System.out.println (Arrays.toString (arr));
//        BubbleSort.bubbleSort (arr);
//        SelectionSort.selectionSort (arr);
//        InsertionSort.insertionSort2 (arr);
//        ShellSort.shellSort (arr);
//        MergeSort.sort (arr);
        QuickSortDemo.sort (arr);
        System.out.println (Arrays.toString (arr));
    }
}
