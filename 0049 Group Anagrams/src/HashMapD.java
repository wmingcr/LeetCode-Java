import java.util.*;

public class HashMapD {

    // I knew we can do it using hash
    // but the smartest way is using HashMap, it contains a way
    // of how to use hash code.

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            if(strs == null || strs.length == 0){
                return new ArrayList ();
            }

            Map<String, List> map = new HashMap<> ();

            for(String str : strs){

                char[] cs = str.toCharArray();

                // change this sort method to counting sort
                // could reduce time complexity from klogk to n
                Arrays.sort(cs);

                String key = new String(cs);

                if(map.containsKey(key) == false){
                    map.put(key, new ArrayList());
                }

                map.get(key).add(str);

            }
            return new ArrayList(map.values());
        }
    }
}
