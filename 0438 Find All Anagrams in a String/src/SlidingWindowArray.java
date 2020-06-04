import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowArray {

    // error#1, 计算count的时候，范围是0-26, 不是0-n
    // error#2， 在s中计算时，i 不能 == m - n, 这样的话 n + i 会越界

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {

            // get lengths
            int m = s.length();
            int n = p.length();

            // validity
            if(s == null || m == 0 || p == null || n == 0 || n > m){
                return new ArrayList ();
            }

            // list, recoding starting indices
            List<Integer> ans = new LinkedList<> ();

            // array, recording char, and its frequency from pattern
            int[] arrP = new int[26];
            int[] arrS = new int[26];


            for(int i = 0; i < n; i ++){
                arrP[p.charAt(i) - 'a']++;
                arrS[s.charAt(i) - 'a']++;
            }

            // unique chars inside of p
            int count = 0;

            // get how many chars and frequency are equal
            for(int i = 0; i < 26; i ++){
                if(arrP[i] == arrS[i]){
                    count++;
                }
            }

            for(int i = 0; i < m - n; i ++){
                if(count == 26){
                    ans.add(i);
                }
                // add one char from right side
                /**
                 Be careful, if i could be == m - n
                 which means n + i could be m, which is out of bound
                 */
                int idx = s.charAt(n + i) - 'a';
                arrS[idx]++;
                if(arrS[idx] == arrP[idx]){
                    count++;
                } else if(arrS[idx] == arrP[idx] + 1){
                    count--;
                }

                idx = s.charAt(i) - 'a';
                arrS[idx]--;
                if(arrS[idx] == arrP[idx]){
                    count++;
                } else if(arrS[idx] == arrP[idx] - 1){
                    count--;
                }
            }

            if(count == 26){
                ans.add(m - n);
            }

            return ans;
        }
    }
}
