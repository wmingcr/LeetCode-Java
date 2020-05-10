package sort.QuickSort;

import java.util.Arrays;

public class Session {

    public static void main(String[] args) {

        int[] arr = new int[]{4, 3, 6, 2, 7};

        System.out.println (Arrays.toString (arr));
        Solution1.quickSort (arr, 0, arr.length - 1);

        System.out.println ("===================");
        System.out.println (Arrays.toString (arr));

        Arrays.sort(arr);

        long ans = Long.MIN_VALUE;

    }

}
