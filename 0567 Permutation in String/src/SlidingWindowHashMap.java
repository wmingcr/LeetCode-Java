import java.util.HashMap;

public class SlidingWindowHashMap {

    // this is not the efficient way, since it's using hashmap

    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            // validity
            if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0){
                return false;
            }
            // get length
            int m = s1.length();
            int n = s2.length();
            // store char and frequencies from s1, pattern
            HashMap<Character, Integer> map = new HashMap<>();
            // if there is a char and its frequency matching, count++
            int count = 0;
            // recording frequency and char
            for(int i = 0; i < m; i ++){
                char c = s1.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            // when count == target, we get a permutation
            int target = map.size();

            for(int i = 0; i < n; i ++){
                // enlarging right side
                char c = s2.charAt(i);
                if(map.containsKey(c)){
                    map.put(c, map.get(c) - 1);
                    // when frequency also matches, count++
                    if(map.get(c) == 0){
                        count++;
                    }
                }
                // if length of sliding window is greater than length s1
                if(i > m - 1){
                    // remove left char
                    c = s2.charAt(i - m);
                    if(map.containsKey(c)){
                        map.put(c, map.get(c) + 1);
                        if(map.get(c) == 1){
                            count--;
                        }
                    }
                }

                if(count == target){
                    return true;
                }
            }
            return false;
        }
    }
}
