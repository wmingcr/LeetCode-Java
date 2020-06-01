import java.util.ArrayList;
import java.util.List;

public class BestExplanation {
    // #1
    // https://leetcode-cn.com/problems/subsets/solution/er-jin-zhi-wei-zhu-ge-mei-ju-dfssan-chong-si-lu-9c/


    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<> ();
            if(nums == null || nums.length == 0){
                return ans;
            }
            ans.add(new ArrayList<>());
            int n = nums.length;
            for(int i = 0; i < n; i ++){
                int num = ans.size();
                for(int j = 0; j < num; j ++){
                    List<Integer> tem = new ArrayList<>(ans.get(j));
                    tem.add(nums[i]);
                    ans.add(tem);
                }
            }
            return ans;
        }
    }


}
