import java.util.*;

public class BackTrack {

    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        List<List<Integer>> ans = new Solution ().combinationSum (arr, 7);
        System.out.println (ans);
    }

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new LinkedList<>();
            if(candidates == null || candidates.length == 0 || target < 1){
                return ans;
            }
            Arrays.sort(candidates);
            int n = candidates.length;
            // for(int i = 0; i < n; i ++){
            backtrack(new ArrayDeque<Integer>(), 0, target, candidates, ans, 0);
            // }
            return ans;
        }
        private void backtrack(ArrayDeque<Integer> curr, int first, int target, int[] arr, List<List<Integer>> ans, int sum){

            if(sum == target){
                ans.add(new LinkedList(curr));
                return;
            }
            if(sum > target){
                return;
            }
            for(int k = first; k < arr.length; k ++){
                if(arr[k] > target - sum){
                    break;
                }
                curr.addLast(arr[k]);
                backtrack(curr, k, target, arr, ans, sum + arr[k]);
                curr.removeLast();
            }
        }
    }
}
