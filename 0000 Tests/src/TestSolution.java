import java.util.ArrayList;
import java.util.List;

public class TestSolution {

    public static void main(String[] args) {
        String s = "asdf";
        System.out.println (s.substring (0, 0));
    }

    static class Solution {

        private void dfs(List<String> res, int start, int count, StringBuilder builder, int len, String s) {
            if (start == len) {
                if (count == 4) {
                    res.add (builder.toString ());
                }
                return;
            }

            if (count >= 4) {
                return;
            }

            int max = Math.min (len, start + 3);
            for (int i = start; i < max; i++) {
                int segment = valid (s, start, i + 1);
                if (segment != -1) {
                    int length = builder.length ();
                    builder.append (segment);
                    if (count < 3) {
                        builder.append (".");
                    }
                    dfs (res, i + 1, count + 1, builder, len, s);
                    builder.setLength (length);
                }
            }
        }

        private int valid(String s, int lo, int hi) {
            int len = hi - lo;
            if (len > 1 && s.charAt (lo) == '0') {
                return -1;
            }
            int res = Integer.parseInt (s.substring (lo, hi));
            return res > 255 ? -1 : res;
        }

        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<> ();
            int len = s.length ();
            if (len < 4 || len > 12) {
                return res;
            }
            dfs (res, 0, 0, new StringBuilder (), len, s);
            return res;
        }

    }
}
