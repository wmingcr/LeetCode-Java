public class TheBest1 {
    class Solution {
        public boolean isValid(String s) {
            if (s == null || s.length () == 0) {
                return true;
            }

            char[] stack = new char[s.length ()];
            int idx = 0;

            for (char c : s.toCharArray ()) {
                switch (c) {
                    case '(':
                        stack[idx++] = ')';
                        break;
                    case '{':
                        stack[idx++] = '}';
                        break;
                    case '[':
                        stack[idx++] = ']';
                        break;
                    default:
                        if (idx == 0 || stack[--idx] != c) {
                            return false;
                        }
                }
            }

            return idx == 0;
        }
    }
}
