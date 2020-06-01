import java.util.HashMap;

public class WithHashMap {

    class Solution {
        public int romanToInt(String s) {
            // validity
            if(s == null || s.length() == 0){
                return 0;
            }
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            int n = s.length();
            int tem = 0, sum = 0;
            for(int i = 0; i < n; i ++){
                int cur = map.get(s.charAt(i));
                if(cur > tem){
                    sum = sum - tem + cur - tem;
                } else {
                    sum += cur;
                }
                tem = cur;
            }
            return sum;
        }

    }
}
