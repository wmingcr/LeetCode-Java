import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DFS {


    class Solution {
        public List<String> restoreIpAddresses(String s) {
            int len = s.length();
            List<String> ans = new ArrayList<> ();
            if(len < 4 || len > 12){
                return ans;
            }
            Deque<String> path = new ArrayDeque<> (4);
            dfs(s, len, 0, 0, path, ans);
            return ans;
        }
        private void dfs(String s, int len, int split, int start, Deque<String> path, List<String> ans){
            if(start == len){
                if(split == 4){
                    ans.add(String.join(".", path));
                }
                return;
            }
            if(len - start < (4 - split) || len - start > 3 * (4 - split)){
                return;
            }
            for(int i = 0; i < 3; i ++){
                if(start + i >= len){
                    break;
                }
                int ipSegement = judegIfSegement(s, start, start+i);
                if(ipSegement != -1){
                    path.addLast(ipSegement + "");
                    dfs(s, len, split+1, start+i+1, path, ans);
                    path.removeLast();
                }
            }
        }
        private int judegIfSegement(String s, int left, int right){
            int len = right - left + 1;
            if(len > 1 && s.charAt(left) == '0'){
                return -1;
            }
            int res = 0;
            for(int i = left; i <= right; i ++){
                res = res * 10 + s.charAt(i) - '0';
            }
            if(res > 255){
                return -1;
            }
            return res;
        }
    }
}
