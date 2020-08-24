import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListSolution {
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            // corner case
            if (intervals == null || intervals.length == 0) {
                return 0;
            }

            Arrays.sort (intervals, (x, y) -> x[0] - y[0]);
            int n = intervals.length;

            ArrayList<int[]> rooms = new ArrayList<> ();
            rooms.add (intervals[0]);

            for (int i = 1; i < n; i++) {

                int[] earlyEndingMeeting = rooms.get (0);
                int size = rooms.size ();
                for (int j = 1; j < size; j++) {
                    int[] currMeeting = rooms.get (j);
                    if (currMeeting[1] < earlyEndingMeeting[1]) {
                        earlyEndingMeeting = currMeeting;
                    }
                }

                if (earlyEndingMeeting[1] <= intervals[i][0]) {
                    rooms.remove (earlyEndingMeeting);
                }

                rooms.add (intervals[i]);
                // res = Math.max(res, rooms.size());
            }

            return rooms.size ();
        }
    }
}
