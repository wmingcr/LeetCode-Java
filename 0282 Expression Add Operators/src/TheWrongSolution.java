import java.util.ArrayList;
import java.util.List;

public class TheWrongSolution {

    public static void main(String[] args) {
        System.out.println (new Solution ().addOperators ("123", 6));
        // 1 + 2 * 3
    }

    static class Solution {

        int n;
        List<String> res;

        private void dfs(String num, int target, int pos, long prev, long cur, StringBuilder builder) {
            if (pos == n) {
                if (cur == target) {
                    res.add (builder.substring (0, builder.length ()));
                }
                return;
            }

            for (int i = pos; i < n; i++) {
                if (i != pos && num.charAt (pos) == '0') {
                    break;
                }
                long val = Long.parseLong (num.substring (pos, i + 1));
                int len = builder.length ();

                // plus
                builder.append ("+").append (val);
                dfs (num, target, i + 1, val, cur + val, builder);
                builder.setLength (len);
                // minus
                builder.append ("-").append (val);
                dfs (num, target, i + 1, -val, cur - val, builder);
                builder.setLength (len);
                // multiplication
                builder.append ("*").append (val);
                dfs (num, target, i + 1, prev * val, cur - prev + prev * val, builder);
                builder.setLength (len);
            }
        }

        public List<String> addOperators(String num, int target) {
            res = new ArrayList<> ();
            if (num == null || num.length () == 0) {
                return res;
            }
            this.n = num.length ();
            dfs (num, target, 0, 0, 0, new StringBuilder ());
            return res;
        }

    }
}

