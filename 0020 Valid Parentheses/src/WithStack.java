import java.util.ArrayDeque;
import java.util.Deque;

public class WithStack {
    class Solution {
        public boolean isValid(String s) {
            if (s == null || s.length () == 0) {
                return true;
            }

            Deque<Character> stack = new ArrayDeque<> ();
            for (int i = 0; i < s.length (); i++) {
                char c = s.charAt (i);
                switch (c) {
                    case '(':
                        stack.push ('(');
                        break;
                    case '{':
                        stack.push ('{');
                        break;
                    case '[':
                        stack.push ('[');
                        break;
                    case '}':
                        if (stack.isEmpty () || stack.pop () != '{') {
                            return false;
                        }
                        break;
                    case ')':
                        if (stack.isEmpty () || stack.pop () != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if (stack.isEmpty () || stack.pop () != '[') {
                            return false;
                        }
                        break;
                }
            }

            return stack.isEmpty ();
        }
    }
}
