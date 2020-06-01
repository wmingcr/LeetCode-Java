package sort.DualPivotQuickSort;

import java.util.Arrays;
import java.util.Random;

public class Session {

    public static void main(String[] args) {
        Arrays.sort(new int[]{1,2,4,3,4,6});
        long t1 = System.currentTimeMillis ();
        testSort (50);
        long t2 = System.currentTimeMillis ();
        System.out.println (t2 - t1);
    }

    private static void testSort(int x) {
        int[] arr = new int[x];
        Random random = new Random ();
        for (int i = 0; i < x; i++) {
            arr[i] = random.nextInt (100);
        }
        System.out.println (Arrays.toString (arr));
        DualPivotQuickSortion.sort (arr);
        System.out.println (Arrays.toString (arr));
    }
}
