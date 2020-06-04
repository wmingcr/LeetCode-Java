import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindow取巧 {


    static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {

            List<Integer> ans = new LinkedList<> ();
            // validity
            if (s == null || s.length () == 0 || words == null || words.length == 0 || words[0].length () == 0) {
                return ans;
            }
            // get lengths
            int len_s = s.length ();
            int m = words.length;
            int n = words[0].length ();
            // sum of chars inside of words
            int sum = m * n;

            if (len_s < sum) {
                return ans;
            }
            // to store all chars and relative frequencies inside of words
            HashMap<String, Integer> map = new HashMap<> (m);
            for (String str : words) {
                map.put (str, map.getOrDefault (str, 0) + 1);
            }

            // for(int i = 0; i <= len_s - sum; i ++){
            //     String str = s.substring(i, i + n);
            //     if(map.containsKey(str) == false){
            //         continue;
            //     }
            //     if(valid(map, i, s, m, n)){
            //         ans.add(i);
            //     }
            // }

            for (int i = 0; i <= len_s - sum; i++) {
                // String str = s.substring(i, i + n);
                // 临时存储当前长度为sum的子字符串
                HashMap<String, Integer> curr = new HashMap<> ();
                for (int j = 0; j < m; j++) {
                    String str = s.substring (i + j * n, i + (j + 1) * n);
                    // 没有不行
                    if (map.containsKey (str) == false) {
                        break;
                    }
                    curr.put (str, curr.getOrDefault (str, 0) + 1);
                    // 大于不行
                    if (curr.get (str) > map.get (str)) {
                        break;
                    }
                    // 所以刚好等于最好
                    if (j + 1 == m) {
                        ans.add (i);
                    }
                }
            }
            return ans;
        }
    }
}
