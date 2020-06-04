public class TwoPointers {


    static class Solution {
        public boolean backspaceCompare(String S, String T) {
            // corner case
            if(S == null || T == null){
                return false;
            }

            int s = S.length() - 1;
            int t = T.length() - 1;

            int skips = 0;
            int skipt = 0;

            while(s >= 0 || t >= 0){
                while(s >= 0){
                    if(S.charAt(s) == '#'){
                        skips ++;
                        s--;
                    } else if(skips > 0){
                        skips--;
                        s--;
                    } else {
                        break;
                    }
                }
                while(t >= 0){
                    if(T.charAt(t) == '#'){
                        skipt++;
                        t--;
                    } else if(skipt > 0){
                        skipt--;
                        t--;
                    } else {
                        break;
                    }
                }
                if(s >= 0 && t >= 0 && S.charAt(s) != T.charAt(t)){
                    return false;
                }
                // if(s < 0 && t >= 0 || s >=0 && t < 0){
                //     return false;
                // }
                if((s >= 0) != (t >= 0)){
                    return false;
                }
                s--;t--;
            }
            return true;
        }
    }
}
