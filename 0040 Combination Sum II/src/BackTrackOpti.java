import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BackTrackOpti {

    class Solution {
        List<List<Integer>> ans = new LinkedList<> ();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            if(candidates == null || candidates.length == 0){
                return ans;
            }
            Arrays.sort(candidates);
            int n = candidates.length;

            backtrack(0, n, new ArrayDeque<Integer> (), 0, target, candidates);
            return ans;
        }
        private void backtrack(int start, int n, ArrayDeque<Integer> curr, int sum, int target, int[] arr){
            if(sum == target){
                ans.add(new LinkedList(curr));
                return;
            }

            for(int i = start; i < n; i ++){
                if(i > start && arr[i] == arr[i-1] ){
                    continue;
                }

                if(arr[i] > target - sum){
                    break;
                }

                curr.addLast(arr[i]);

                backtrack(i+1, n, curr, sum+arr[i], target, arr);

                curr.removeLast();
            }
        }
    }
}
