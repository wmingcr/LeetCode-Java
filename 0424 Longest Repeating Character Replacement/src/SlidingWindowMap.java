import java.util.HashMap;

public class SlidingWindowMap {



    static class Solution {
        public int characterReplacement(String s, int k) {
            // validity
            if(s == null || s.length() == 0 || k < 0){
                return 0;
            }
            // two pointers
            int start = 0, end = 0;
            // ans recording answer
            int ans = 0;
            // maxCount recording the length of the letter which repeated most times
            int maxCount = 0;
            // map to store char and its frenquencies, from s,
            HashMap<Character, Integer> map = new HashMap<>();

            // sliding window
            while(end < s.length()){
                char cE = s.charAt(end);
                map.put(cE, map.getOrDefault(cE, 0) + 1);
                maxCount = Math.max(maxCount, map.get(cE));
                end++;

                // if there are more than k characters inside of sliding window
                while(end - start - maxCount > k){
                    char cS = s.charAt(start);
                    map.put(cS, map.get(cS) - 1);
                    start++;
                }

                ans = Math.max(ans, end - start);
            }

            return ans;
        }
    }
}
