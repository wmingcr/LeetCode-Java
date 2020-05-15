import java.util.HashSet;

class Solution_SlidingWindow {
    public int lengthOfLongestSubstring(String s) {
        //validity
        if(s == null || s.length() == 0){
            return 0;
        }

        int len = 0, lo = 0, hi = 0, n = s.length();

        HashSet<Character> hashSet = new HashSet<>();

        while(lo < n && hi < n){
            if(hashSet.contains(s.charAt(hi))){
                hashSet.remove(s.charAt(lo++));
            } else {
                hashSet.add(s.charAt(hi++));
                len = Math.max(len, hi - lo);
            }
        }

        return len;
    }
}