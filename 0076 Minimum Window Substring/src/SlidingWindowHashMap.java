import java.util.HashMap;

public class SlidingWindowHashMap {




    class Solution {
        public String minWindow(String s, String t) {

            if(s == null || s.length() == 0 || t == null || t.length() == 0){
                return "";
            }

            HashMap<Character, Integer> need = new HashMap<>();

            for(int i = 0; i < t.length(); i++){
                int count = need.getOrDefault(t.charAt(i), 0);
                need.put(t.charAt(i), count+1);
            }

            int left = 0, right = 0;

            int required = need.size();

            int formed = 0;

            HashMap<Character, Integer> window = new HashMap<>();

            int[] ans = {-1, 0, 0};

            while(right < s.length()){

                char c = s.charAt(right);
                int count = window.getOrDefault(c, 0);
                window.put(c, count+1);

                if(need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()){
                    formed++;
                }

                while(left <= right && formed == required){

                    if(ans[0] == -1 || right-left+1 < ans[0]){
                        ans[0] = right-left+1;
                        ans[1] = left;
                        ans[2] = right;
                    }

                    c = s.charAt(left);

                    window.put(c, window.get(c)-1);

                    if(need.containsKey(c) && window.get(c).intValue() < need.get(c).intValue()){
                        formed--;
                    }
                    left ++;
                }
                right++;
            }
            return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
        }
    }
}
