import java.util.ArrayList;
import java.util.List;

public class TheBestBitMask {


    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<> ();
            if(nums == null || nums.length == 0){
                return ans;
            }
            int n = nums.length;
            int a = 1 << n;
            for(int i = 0; i < a; i ++){
                List<Integer> tem = new ArrayList<>();
                for(int k = 0; k < n; k ++){
                    // the important part
                    if(((i >> k) & 1) != 0){
                        tem.add(nums[k]);
                    }
                }
                ans.add(tem);
            }
            return ans;
        }
    }
}
