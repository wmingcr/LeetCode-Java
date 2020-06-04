public class SlidingWindowArray {

    // this method is quiet more efficient, using array instead of Set/Map

    static class Solution {
        public String minWindow(String s, String t) {
            // validity
            if(s == null || t == null ){
                return "";
            }

            int len_s = s.length();
            int len_t = t.length();

            if(len_s == 0 || len_t == 0 || len_t > len_s){
                return "";
            }

            int[] arrt = new int[128];
            int[] arrs = new int[128];
            int target = 0;// unique characters

            for(int i = 0; i < len_t; i ++){
                int idx = t.charAt(i);
                arrt[idx]++;
                if(arrt[idx] == 1){
                    target++;
                }
            }

            int len = Integer.MAX_VALUE;
            int ans = 0;

            int count = 0;

            for(int i = 0, j = 0; j < len_s; j ++){
                // enlarging right side
                int cr = s.charAt(j);
                arrs[cr]++;
                if(arrs[cr] == arrt[cr]){
                    count++;
                }

                while(count == target){
                    if(j - i + 1 < len){
                        len = j - i + 1;
                        ans = i;
                    }
                    // shrinking from left side
                    int cl = s.charAt(i);
                    arrs[cl]--;
                    if(arrs[cl] == arrt[cl] - 1){
                        count--;
                    }
                    i++;
                }
            }

            return len == Integer.MAX_VALUE ? "" : s.substring(ans, ans + len);
        }
    }
}
