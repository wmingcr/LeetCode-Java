public class SlidingWindowArrayFastest {

    // it turns out that array is more faster than HashMap

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
            // map to store char and its frequencies, from s,
            //HashMap<Character, Integer> map = new HashMap<>();

            // since there are only upper cases inside of s
            // we could use array to store frequencies
            int[] cs = new int[26];

            // sliding window
            while(end < s.length()){
                int idx = s.charAt(end) - 'A';
                cs[idx] ++; end ++;
                maxCount = Math.max(maxCount, cs[idx]);

                // more than k different chars during sliding window
                while(end - start - maxCount > k){
                    idx = s.charAt(start) - 'A';
                    cs[idx] --;
                    start ++;
                }

                ans = Math.max(ans, end - start);
            }

            return ans;
        }
    }
}
