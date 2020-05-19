public class Solution {


    public boolean isPalindrome(String s) {
        // validity
        if (s == null) {
            return false;
        }
        // two pointers
        int lo = 0, hi = s.length () - 1;
        while (lo < hi) {
            while (lo < hi && notValid (s.charAt (lo))) {
                lo++;
            }
            while (lo < hi && notValid (s.charAt (hi))) {
                hi--;
            }
            // digits or lower cases
            if (toLowerCase (s.charAt (lo)) != toLowerCase (s.charAt (hi))) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    // to lower case
    private char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            c -= 'A' - 'a';
        }
        return c;
    }

    // not a digit and a character
    private boolean notValid(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return false;
        }
        return true;
    }

}
