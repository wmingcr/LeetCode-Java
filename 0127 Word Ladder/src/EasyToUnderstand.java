import java.util.*;

public class EasyToUnderstand {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> dict = new HashSet<> (wordList);
            Queue<String> queue = new LinkedList<> ();
            queue.add (beginWord);
            int level = 1;
            while (!queue.isEmpty ()) {
                int size = queue.size ();
                for (int q = 0; q < size; q++) {
                    char[] cur = queue.poll ().toCharArray ();
                    for (int i = 0; i < cur.length; i++) {
                        char tem = cur[i];
                        for (char ch = 'a'; ch <= 'z'; ch++) {
                            cur[i] = ch;
                            String dest = new String (cur);
                            if (dict.contains (dest)) {
                                if (dest.equals (endWord)) {
                                    return level + 1;
                                }
                                queue.add (dest);
                                dict.remove (dest);
                            }
                        }
                        cur[i] = tem;
                    }
                }
                level++;
            }
            return 0;
        }
    }
}
