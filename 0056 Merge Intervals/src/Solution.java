import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    class Solutions {
        public int[][] merge(int[][] intervals) {
            // corner case
            if(intervals == null || intervals.length == 0){
                return new int[0][];
            }

            Arrays.sort(intervals, 0, intervals.length, new Array2DComparator());

            List<int[]> res = new ArrayList<> ();
            int[] prev = null;

            for(int[] mid : intervals){
                if(prev == null){
                    prev = mid;
                } else {
                    if(prev[1] >= mid[0]){
                        prev[0] = Math.min(prev[0], mid[0]);
                        prev[1] = Math.max(prev[1], mid[1]);
                    } else {
                        res.add(prev);
                        prev = mid;
                    }
                }
            }

            if(prev != null){
                res.add(prev);
            }

            return res.toArray(new int[0][0]);
        }
    }

    class Array2DComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b){
            return a[0] - b[0];
        }
    }
}
