package bitmask;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class Session {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<> ();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for(Map.Entry<String, Integer> entry : set){
            System.out.println ("Key = " + entry.getKey () +
                    ", Value = " + entry.getValue ());
        }

        Set<String> keySet = map.keySet ();
        for(String key : keySet){
            System.out.println ("key = " + key + ", value = " + map.get(key));
        }
        map.clear();
    }
}
