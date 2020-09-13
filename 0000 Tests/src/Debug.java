import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Debug {

    public static void main(String[] args) {
        System.out.println (new Solution().combinationSum3 (3, 7));;
    }

    static class Solution {
        List<List<Integer>> res = new ArrayList<> ();
        public List<List<Integer>> combinationSum3(int k, int n) {
            if(k <= 0 || n <= 0 || n > 55){
                return res;
            }
            backtrack(1, n, k, new LinkedList<Integer> (), 0);
            return res;
        }

        private void backtrack(int start, int n, int k, LinkedList<Integer> curr, int sum){
            if(sum > n){
                return;
            }
            if(curr.size() > k){
                return;
            }
            if(curr.size() == k){
                if(sum == n){
                    res.add(new ArrayList(curr));
                }
                return;
            }
            for(int i = start; i < n; i ++){
                if(i > n - sum){
                    return;
                }
                curr.add(i);
                backtrack(start + 1, n, k, curr, sum + i);
                curr.removeLast();
            }
        }
    }

}
