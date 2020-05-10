package sort.QuickSort;

public class Solution2 {

    //GeeksforGeeks
    //https://www.geeksforgeeks.org/quick-sort/

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
        /* pi is partitioning index, arr[pi] is now
           at right place */
            int pi = partition (arr, low, high);

            quickSort (arr, low, pi - 1);  // Before pi
            quickSort (arr, pi + 1, high); // After pi
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // pivot (Element to be placed at right position)
        int pivot = arr[high];

        int i = (low - 1);  // Index of smaller element

        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;    // increment index of smaller element
                swap (arr, i, j);
            }
        }

        swap (arr, i + 1, high);

        return (i + 1);
    }

    private static void swap(int[] arr, int a, int b) {
        int te = arr[a];
        arr[a] = arr[b];
        arr[b] = te;
    }
}
