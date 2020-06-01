import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WeiweiAns {

    // 力扣官方解答，视频
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<> ();
            if(nums == null || nums.length == 0){
                return ans;
            }
            int n = nums.length;
            Stack<Integer> path = new Stack<>();
            boolean[] used = new boolean[n];
            int len = 0;
            backtrack(nums, path, len, used, ans, n);
            return ans;
        }
        private void backtrack(int[] nums, Stack<Integer> path, int len, boolean[] used, List<List<Integer>> ans, int n){
            if (len == n){
                ans.add(new ArrayList(path));
                return;
            }
            for(int i = 0; i < n; i ++){
                if(used[i]){
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                backtrack(nums, path, len + 1, used, ans, n);
                used[i] = false;
                path.pop();
            }
        }
    }
}
