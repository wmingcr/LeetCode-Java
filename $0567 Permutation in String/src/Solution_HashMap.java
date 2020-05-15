import java.util.HashMap;
import java.util.Map;

public class Solution_HashMap {

    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()){
            return false;
        }

        Map<Character, Integer> s1Map = new HashMap<> ();

        for(int i = 0; i < s1.length(); i ++){
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0)+1);
        }

        for(int i = 0; i <= s2.length()-s1.length(); i++){
            Map<Character, Integer> s2Map = new HashMap<>();
            for(int j = i; j < s1.length()+i; j++){
                s2Map.put(s2.charAt(j), s2Map.getOrDefault(s2.charAt(j), 0)+1);
            }
            if(match(s1Map, s2Map)){
                return true;
            }
        }
        return false;
    }

    private boolean match(Map<Character, Integer> s1Map, Map<Character, Integer> s2Map){
        for(char c : s1Map.keySet()){
            if(s1Map.get(c).intValue() != s2Map.getOrDefault(c, 0).intValue()){
                return false;
            }
        }
        return true;
    }

}
