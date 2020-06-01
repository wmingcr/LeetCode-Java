public class SlidingWindowCharArray {

    // 在某种程度上，直接操作String转换成的数组，速度会更快一些

    static class Solution {
        public int characterReplacement(String s, int k) {
            // validity
            if(s == null || s.length() == 0 || k < 0){
                return 0;
            }
            char[] ss = s.toCharArray();
            // two pointers
            int start = 0, end = 0;
            // ans recording answer
            int ans = 0;
            // maxCount recording the length of the letter which repeated most times
            int maxCount = 0;
            // map to store char and its frenquencies, from s,
            //HashMap<Character, Integer> map = new HashMap<>();

            // since there are only upper cases inside of s
            // we could use array to store frequencies
            int[] cs = new int[128];

            // sliding window
            while(end < ss.length){
                maxCount = Math.max(maxCount, ++cs[ss[end++]]);

                // more than k different chars during sliding window
                if(end - start - maxCount > k){
                    cs[ss[start++]] --;
                }

                ans = Math.max(ans, end - start);
            }

            return ans;
        }
    }
}
