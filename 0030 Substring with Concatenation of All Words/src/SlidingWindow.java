import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SlidingWindow {

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println (new Solution ().findSubstring (s, words));
    }

    static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {

            List<Integer> ans = new LinkedList<>();
            // validity
            if(s == null || s.length() == 0 || words == null || words.length == 0 || words[0].length() == 0){
                return ans;
            }
            // get lengths
            int len_s = s.length();
            int m = words.length;
            int n = words[0].length();
            // sum of chars inside of words
            int sum = m * n;

            if(len_s < sum){
                return ans;
            }
            // to store all chars and relative frequencies inside of words
            HashMap<String, Integer> map = new HashMap<>(m);
            for(String str : words){
                map.put(str, map.getOrDefault(str, 0) + 1);
            }

            for(int i = 0; i <= len_s - sum; i ++){
                String str = s.substring(i, i + n);
                if(map.containsKey(str) == false){
                    continue;
                }
                if(valid(map, i, s, m, n)){
                    ans.add(i);
                }
            }
            return ans;
        }
        private boolean valid(HashMap<String, Integer> map, int start, String s, int m, int n){
            HashMap<String, Integer> maps = new HashMap<>();
            for(int i = 0; i < m; i ++){
                String str = s.substring(start + i * n, start + (i + 1) * n);
                maps.put(str, maps.getOrDefault(str, 0) + 1);
            }
            if(maps.size() != map.size()){
                return false;
            }
            // for(int i = 0; i < m; i ++){
            //     String str = s.substring(start + i * n, start + (i + 1) * n);
            //     if(map.getOrDefault(str, 0) != maps.getOrDefault(str, 0)){
            //         return false;
            //     }
            // }
            Set<String> set = map.keySet();
            for(String str : set){
                if(map.getOrDefault(str, 0) != maps.getOrDefault(str, 0)){
                    return false;
                }
            }
            return true;
        }
    }

}
