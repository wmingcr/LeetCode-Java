import java.util.HashMap;

public class WithArray {
    class Solution {
        public String getHint(String secret, String guess) {
            int a = 0, b = 0;
            int[] count = new int[10];
            for (int i = 0; i < secret.length (); i++) {
                int x = secret.charAt (i) - '0';
                int y = guess.charAt (i) - '0';
                if (x == y) {
                    a++;
                } else {
                    if (count[x] < 0)
                        b++;
                    if (count[y] > 0)
                        b++;
                    count[x]++;
                    count[y]--;
                }
            }
            return a + "A" + b + "B";
        }
    }
}
