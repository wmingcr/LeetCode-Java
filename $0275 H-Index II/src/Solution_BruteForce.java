public class Solution_BruteForce {


    public int hIndex(int[] citations) {
        //validity
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int n = citations.length;

        for (int i = 0; i < citations.length; i++, n--) {
            if (citations[i] >= n) {
                return n;
            }
        }

        return 0;
    }
}
