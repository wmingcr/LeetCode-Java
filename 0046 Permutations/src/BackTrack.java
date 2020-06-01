import java.util.ArrayList;
import java.util.List;

public class BackTrack {

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<> ();
            // validity
            if(nums == null || nums.length == 0){
                return ans;
            }
            backtrack(ans, new ArrayList<Integer>(), nums);
            return ans;
        }

        private void backtrack(List<List<Integer>> ans, List<Integer> curr, int[] nums){
            // get one permutation
            if(curr.size() == nums.length){
                ans.add(new ArrayList<>(curr));
                return;
            }
            for(int num : nums){
                    // check whether num already exits in curr
                    if(curr.contains(num)){
                        continue;
                    }
                    curr.add(num);
                    backtrack(ans, curr, nums);
                    curr.remove(curr.size() - 1);
            }
        }
    }
}
