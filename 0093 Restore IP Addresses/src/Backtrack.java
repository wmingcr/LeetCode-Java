import java.util.LinkedList;
import java.util.List;

public class Backtrack {

    public static void main(String[] args) {
        String str = "25525511135";
        List<String> ans = new Solution ().restoreIpAddresses (str);
        System.out.println (ans);
    }

    static class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> ans = new LinkedList<> ();
            if(s == null || s.length() < 4){
                return ans;
            }
            backtrack(0, 0, "", ans, s);
            return ans;
        }
        private void backtrack(int num, int start, String curr, List<String> ans, String s){
            if(num == 4){
                if(curr.length() - 3 == s.length()){
                    ans.add(curr);
                }
                return;
            }

            String tem = curr;
            String str = "";
            // 1
            int lo = start, hi = start+1;

            if(hi < s.length()){
                str = s.substring(start, start+1);
                if(num < 3){
                    curr += str + ".";
                } else {
                    curr += str;
                }
                backtrack(num+1, hi, curr, ans, s);
            }


            // 2
            lo = start; hi = start+2;

            if(hi < s.length()){
                curr = tem;
                str = s.substring(start, start+2);
                if(num < 3){
                    curr += str + ".";
                } else {
                    curr += str;
                }
                backtrack(num+1, hi, curr, ans, s);
            }

            // 3
            lo = start; hi = start+3;

            if(hi < s.length()){
                curr = tem;
                str = s.substring(start, start+3);
                if(num < 3){
                    curr += str + ".";
                } else {
                    curr += str;
                }
                backtrack(num+1, start+3, curr, ans, s);
            }
        }
    }
}
