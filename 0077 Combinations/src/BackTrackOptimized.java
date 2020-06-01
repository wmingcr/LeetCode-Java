import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BackTrackOptimized {


    class Solution {

        List<List<Integer>> ans = new ArrayList<> ();

        public List<List<Integer>> combine(int n, int k) {

            if(n <= 0 || k <= 0 || n < k){
                return ans;
            }
            LinkedList<Integer> curr = new LinkedList<>();
            backtrack(1, n, k, curr);
            return ans;

        }

        private void backtrack(int start, int end, int k, LinkedList<Integer> curr){
            if(curr.size() == k){
                ans.add(new ArrayList(curr));
                return;
            }

            // optimized the right bound for i
            for(int i = start; i <= end - (k - curr.size()) + 1; i ++){
                curr.addLast(i);
                backtrack(i+1, end, k, curr);
                curr.removeLast();
            }
        }

    }
}
