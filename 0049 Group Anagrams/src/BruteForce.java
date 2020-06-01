import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteForce {

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            List<List<String>> ans = new ArrayList<>();

            if(strs == null || strs.length == 0){
                return ans;
            }

            for(int i = 0; i < strs.length; i ++){

                char[] tar = strs[i].toCharArray();

                boolean stored = false;

                for(int k = 0; k < ans.size(); k ++){

                    List<String> storedList = ans.get(k);

                    String stredStr = storedList.get(0);

                    char[] stredChar = stredStr.toCharArray();

                    if(equal(tar, stredChar)){
                        storedList.add(strs[i]);
                        stored = true;
                        break;
                    }
                }

                if(stored == false){
                    List<String> tem = new ArrayList<> ();
                    tem.add(strs[i]);
                    ans.add(tem);
                }
            }
            return ans;
        }
        private boolean equal(char[] a, char[] b){
            if(a.length != b.length){
                return false;
            }
            // counting sort doesn't reduce the amount of time
            Arrays.sort(a);
            Arrays.sort(b);

            for(int i = 0; i < a.length; i ++){
                if(a[i] != b[i]){
                    return false;
                }
            }
            return true;
        }
    }
}
