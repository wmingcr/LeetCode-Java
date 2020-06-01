import java.util.LinkedList;
import java.util.List;

public class OptimizedRecursion {

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new LinkedList<> ();
            if (n <= 0) {
                return res;
            }
            backtrack (0, 0, n, new char[2 * n], res);
            return res;
        }

        private void backtrack(int left, int right, int n, char[] cs, List<String> res) {
            // if(left < right){
            //     return;
            // }
            if (left == right && left == n) {
                res.add (new String (cs));
                return;
            }
            if (left < n) {
                cs[left + right] = '(';
                backtrack (left + 1, right, n, cs, res);
            }
            // only when left is greater than right
            // we can add ')'
            // so, there is no need to test whether left is less than right
            if (left > right) {
                cs[left + right] = ')';
                backtrack (left, right + 1, n, cs, res);
            }
        }
    }
}
