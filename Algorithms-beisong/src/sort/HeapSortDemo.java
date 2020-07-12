package sort;

import java.util.Arrays;

public class HeapSortDemo {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7, 9, 4, 75};
        HeapSortDemo ob = new HeapSortDemo ();
        ob.sort(arr);
        System.out.println ("Sorted array is");
        System.out.println (Arrays.toString (arr));
    }

    private static void sort(int[] arr){
        int n = arr.length;

        // build heap (rearrange array)
        for(int i = n/2 - 1; i >=0; i --){
            heapify(arr, n, i);
        }

        // one by one extract an element from heap
        for(int i = n-1; i > 0; i --){
            // move current root to end
            int tem = arr[0];
            arr[0] = arr[i];
            arr[i] = tem;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // to heapify a subtree rooted with node i which is an
    // index in arr[], n is the size of heap
    private static void heapify(int[] arr, int n, int i){

        int largest = i; // initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        // if left child is larger than root
        if(l < n && arr[l] > arr[largest]){
            largest = l;
        }

        // if right child is larger than largest so far
        if(r < n && arr[r] > arr[largest]){
            largest = r;
        }

        // if the largest is not root
        if(largest != i){
            int tem = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tem;

            // recursively heapify the affected sub-tree
            heapify (arr, n, largest);
        }
    }
}
