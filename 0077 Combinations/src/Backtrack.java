import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Backtrack {

    public static void main(String[] args) {
        System.out.println (new Solution ().combine (4, 2));
    }
    static class Solution {

        List<List<Integer>> ans = new ArrayList<> ();

        public List<List<Integer>> combine(int n, int k) {

            if(n < 0 || k < 0){
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
            for(int i = start; i <= end; i ++){

                curr.addLast(i);
                backtrack(i+1, end, k, curr);
                curr.removeLast();
            }
        }

    }
}
