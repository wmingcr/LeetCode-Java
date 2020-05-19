import java.util.Arrays;

public class Solution_Sort {


    public int hIndex(int[] citations) {
        //validity
        if (citations == null || citations.length == 0) {
            return 0;
        }

        // sort
        Arrays.sort (citations);

        // two pointers
        int l = 0, n = citations.length, r = n - 1;

        // binary search
        while (l <= r) {

            // mid pointer
            int mid = l + ((r - l) >> 1);

            if (citations[mid] == n - mid) {
                return n - mid;
            } else if (citations[mid] < n - mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return n - l;
    }
}

