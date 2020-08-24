import java.util.ArrayList;
import java.util.List;

public class Another {


    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {

            List<int[]> res = new ArrayList<> ();

            for (int[] interval : intervals) {
                // 先考虑左侧不交接的情况， 和 newinterval 是空的情况
                if (newInterval == null || interval[1] < newInterval[0]) {
                    res.add (interval);
                } else if (interval[0] > newInterval[1]) { // 右侧不交接的情况
                    res.add (newInterval);
                    newInterval = null;
                    res.add (interval);
                } else { // 合并两个 interval
                    newInterval[0] = Math.min (interval[0], newInterval[0]);
                    newInterval[1] = Math.max (interval[1], newInterval[1]);
                }
            }

            // 单独考虑如果矩阵为空的情况
            if (newInterval != null) {
                res.add (newInterval);
            }

            return res.toArray (new int[0][0]);
        }
    }

}
