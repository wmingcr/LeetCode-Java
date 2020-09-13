import java.util.*;

public class Test {



    public static void main(String[] args) {
        System.out.println ("30".compareTo ("3050"));

        String[] arr = {"3", "5", "1", "10", "19"};

        Arrays.sort (arr);

        System.out.println (Arrays.toString (arr));
    }


    static class Solution {

        private boolean dfs(String s, Set<String> words, int pos, int n, Boolean[] memo) {
            if (pos == n) {
                return true;
            }

            for (int i = pos; i < n; i++) {
                String str = s.substring (pos, i + 1);

                if (words.contains (str) && dfs (s, words, i + 1, n, memo)) {
                    return memo[pos] = true;
                }
            }

            return memo[pos] = false;
        }

        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> words = new HashSet<> (wordDict);
            return dfs (s, words, 0, s.length (), new Boolean[s.length ()]);
        }

    }
}
