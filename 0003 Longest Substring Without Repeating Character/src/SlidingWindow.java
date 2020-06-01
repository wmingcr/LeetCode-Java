import java.util.HashMap;

public class SlidingWindow {

    public static void main(String[] args) {
        String s = "abba";
        System.out.println (new Solution ().lengthOfLongestSubstring (s));
    }


    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            // validity
            if(s == null || s.length() == 0){
                return 0;
            }

            int max = 0, n = s.length();

            HashMap<Character, Integer> map = new HashMap<>();

            for(int i = 0, j = 0; j < n; j++){
                char rc = s.charAt(j);
                if(map.containsKey(rc)){
                    i = Math.max(i, map.get(rc) + 1);
                }

                map.put(rc, j);

                max = Math.max(max, j - i + 1);
            }

            return max;
        }
    }
}
