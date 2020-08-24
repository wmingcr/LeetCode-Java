import java.util.HashSet;
import java.util.Set;

public class ThreeSets {
    class Solution {
        int res = 0;
        Set<Integer> cols = new HashSet<> ();
        Set<Integer> diff = new HashSet<> ();
        Set<Integer> sums = new HashSet<> ();

        public int totalNQueens(int n) {
            if (n <= 0) {
                return 0;
            }

            dfs (0, n);
            return res;
        }

        private void dfs(int level, int n) {
            if (level == n) {
                res++;
                return;
            }

            for (int i = 0; i < n; i++) {
                if (!cols.contains (i) && !sums.contains (i + level) && !diff.contains (level - i)) {
                    cols.add (i);
                    sums.add (i + level);
                    diff.add (level - i);
                    dfs (level + 1, n);
                    cols.remove (i);
                    sums.remove (i + level);
                    diff.remove (level - i);
                }
            }
        }
    }
}
