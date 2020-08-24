import java.util.HashMap;

public class Map {
    class Solution {
        public String getHint(String secret, String guess) {
            char[] st = secret.toCharArray ();
            char[] gs = guess.toCharArray ();
            HashMap<Character, Integer> map = new HashMap<> ();

            int a = 0;
            for (int i = 0; i < st.length; i++) {
                if (st[i] == gs[i]) {
                    a++;
                } else {
                    map.put (st[i], map.getOrDefault (st[i], 0) + 1);
                }
            }

            int b = 0;

            for (int i = 0; i < gs.length; i++) {
                if (gs[i] != st[i]) {
                    if (map.containsKey (gs[i])) {
                        int val = map.get (gs[i]);
                        val--;
                        if (val == 0) {
                            map.remove (gs[i]);
                        } else {
                            map.put (gs[i], val);
                        }
                        b++;
                    }
                }
            }
            return a + "A" + b + "B";
        }
    }
}
