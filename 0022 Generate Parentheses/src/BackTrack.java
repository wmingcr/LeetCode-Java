import java.util.LinkedList;
import java.util.List;

public class BackTrack {

    // this method should be recursion
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new LinkedList<> ();
            // validity
            if(n <= 0)
            {
                return ans;
            }
            // char[] cs = new char[n*2];
            int left = 0, right = 0;
            backtrack(left, right, n, ans, "");
            return ans;
        }
        private void backtrack(int left, int right, int n, List<String> ans, String s){
            if(left < right){
                return;
            }
            if(left == right && left == n){
                ans.add(new String(s));
                return;
            }
            if(left < n){
                backtrack(left + 1, right, n, ans, s + "(");
            }
            if(right < n){
                backtrack(left, right + 1, n, ans, s + ")");
            }
        }
    }
}
