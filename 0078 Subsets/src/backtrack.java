import java.util.ArrayList;
import java.util.List;

public class backtrack {

    public static void main(String[] args) {
        System.out.println ("asdf");
    }

    class Solution {

        List<List<Integer>> ans = new ArrayList<> ();
        int n, k;
        public List<List<Integer>> subsets(int[] nums) {

            // validity
            if(nums == null || nums.length == 0){
                return ans;
            }

            n = nums.length;

            for(k = 0; k < n+1; k++){
                backtrack(0, new ArrayList<Integer>(), nums);
            }
            return ans;
        }

        private void backtrack(int first, ArrayList<Integer> curr, int[] nums){
            // if the combination is done
            if(curr.size() == k){
                ans.add(new ArrayList(curr));
                return; // change time from 50% to 100%
            }
            for(int i = first; i < n; i ++){
                curr.add(nums[i]); // add i to the current combination
                backtrack(i+1, curr, nums); // use next integers to complete the combination
                curr.remove(curr.size() - 1); // backtrack
            }
        }
    }
}
