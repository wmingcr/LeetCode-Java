import java.util.HashSet;
import java.util.Set;

public class Solution1_nSquare {

    class Solution {
        public int uniqueLetterString(String s) {
            // corner case
            if(s == null || s.length() == 0){
                return 0;
            }

            double res = 0D;
            int n = s.length();

            for(int i = 0; i < n; i ++){
                Set<Character> set1 = new HashSet<> ();
                Set<Character> set2 = new HashSet<>();
                for(int j = i; j < n; j ++){
                    char c = s.charAt(j);
                    if(set1.add(c)){
                        set2.add(c);
                    } else {
                        set2.remove(c);
                    }
                    res += set2.size();
                }
            }
            return (int)(res % 100_000_007);
        }
    }
}
