import java.util.LinkedList;
import java.util.List;

public class BruteForce {

    // iterate all possible answers, delete all invalids
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new LinkedList<> ();
            // validity
            if(n <= 0)
            {
                return ans;
            }
            char[] cs = new char[2*n];
            int sum = 1 << n;
            backtrack(cs, 0, ans);
            return ans;
        }
        private void backtrack(char[] cs, int depth, List<String> ans){
            if(depth == cs.length){
                if(valid(cs)){
                    ans.add(new String(cs));
                }
                return;
            }
            cs[depth] = '(';
            backtrack(cs, depth+1, ans);
            cs[depth] = ')';
            backtrack(cs, depth+1, ans);
        }
        private boolean valid(char[] cs){
            int left = 0;
            int right = 0;
            for(char c : cs){
                if(c == '('){
                    left ++;
                } else {
                    right ++;
                }
                if(left < right){
                    return false;
                }
            }
            return left == right;
        }
    }
}
