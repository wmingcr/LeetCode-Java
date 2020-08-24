import java.util.ArrayDeque;
import java.util.Deque;

public class TheBest巨Diao {
    class Solution {
        public boolean isValid(String s) {
            if (s == null || s.length () == 0) {
                return true;
            }

            Deque<Character> stack = new ArrayDeque<> ();
            for (char c : s.toCharArray ()) {
                if (c == '(') {
                    stack.push (')');
                } else if (c == '{') {
                    stack.push ('}');
                } else if (c == '[') {
                    stack.push (']');
                } else if (stack.isEmpty () || stack.pop () != c) {
                    return false;
                }
            }

            return stack.isEmpty ();
        }
    }
}
