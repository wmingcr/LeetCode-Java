import java.util.Arrays;

public class Solution_CountingSortBinarySearch {

    public int hIndex(int[] citations) {
        // validity
        if (citations == null || citations.length == 0) {
            return 0;
        }

        // do counting sort, TC, O(n); SC, O(n)
        int[] ansArr = countingSort (citations);

        System.out.println (Arrays.toString (ansArr));
        // binary search to find h idx
        return binarySearch (ansArr);
    }

    private int binarySearch(int[] arr) {

        // two pointers
        int lo = 0, n = arr.length, hi = n - 1;

        // binary search
        while (lo <= hi) {

            //mid pointer
            int mid = lo + ((hi - lo) >> 1);

            if (arr[mid] == n - mid) {
                return arr[mid];
            } else if (arr[mid] < n - mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return n - lo;
    }

    private int[] countingSort(int[] arr) {

        // new array
        int[] brr = new int[arr.length];

        // get min and max from arr
        int min = arr[0], max = arr[0];
        for (int num : arr) {
            if (min > num) {
                min = num;
            }
            if (max < num) {
                max = num;
            }
        }

        // k is the dif between max and min plus 1
        int k = max - min + 1;
        int[] crr = new int[k];

        // get the frequency of arr into crr
        for (int i = 0; i < arr.length; i++) {
            crr[arr[i] - min]++;
        }

        //get the relative position
        for (int i = 1; i < k; i++) {
            crr[i] += crr[i - 1];
        }

        // store element from arr into brr according to its relative position
        for (int i = arr.length - 1; i >= 0; i--) {
            brr[--crr[arr[i] - min]] = arr[i];
        }
        return brr;
    }

}
