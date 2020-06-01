import java.util.ArrayList;
import java.util.List;

public class DfsNew {

    // new
    // Character.isLetter(c);
    // 大小写转换，c = (char)(c ^ (1 << 5));
    // see explanation:

    class Solution {
        public List<String> letterCasePermutation(String s) {
            List<String> ans = new ArrayList<> ();
            if(s == null || s.length() == 0){
                return ans;
            }
            int n = s.length();
            char[] cs = s.toCharArray();
            char[] curr = new char[n];
            dfs(0, n, curr, cs, ans);
            return ans;
        }
        private void dfs(int start, int end, char[] curr, char[] cs, List<String> ans){
            if(start == end){
                ans.add(new String(curr));
                return;
            }

            curr[start] = cs[start];
            dfs(start+1, end, curr, cs, ans);

            char c = cs[start];

            if (c >= 'a' && c <= 'z') {
                c = (char)(c - 'a' + 'A');
                curr[start] = c;
                dfs(start+1, end, curr, cs, ans);
            }

            c = cs[start];

            if (c >= 'A' && c <= 'Z') {
                c = (char)(c + 'a' - 'A');
                curr[start] = c;
                dfs(start+1, end, curr, cs, ans);
            }
        }
    }
}
