import java.util.*;

public class Backtrack {

    class solution{
        // List to store all permutations
        List<List<Integer>> ans = new ArrayList<> ();
        public List<List<Integer>> permuteUnique(int[] nums){
            // validity
            if(nums == null || nums.length == 0){
                return ans;
            }
            Arrays.sort(nums);
            int n = nums.length;
            int depth = 0;
            Deque<Integer> path = new ArrayDeque<> ();
            boolean[] used = new boolean[n];
            backtrack(nums, depth, n, path, used);
            return ans;
        }
        private void backtrack(int[] nums, int depth, int n, Deque<Integer> path, boolean[] used){
            // ending condition
            if(depth == n){
                ans.add(new ArrayList<>(path));
                return;
            }
            for(int i = 0; i < n; i ++){
                if(used[i]){
                    continue;
                }
                if(i > 0 && nums[i] == nums[i-1] && used[i-1] == false){
                    continue;
                }
                path.add(nums[i]);
                backtrack (nums, depth, n, path, used);
                path.removeLast();
            }
        }
    }
}
