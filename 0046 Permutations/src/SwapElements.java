import java.util.ArrayList;
import java.util.List;

public class SwapElements {

    public static void main(String[] args) {
        Solution s = new Solution ();
        int[] arr = {1,2,3};
        List<List<Integer>> ans = s.permute (arr);
        System.out.println (ans);
    }

    static class Solution {
        List<List<Integer>> ans = new ArrayList<> ();
        public List<List<Integer>> permute(int[] nums) {
            if(nums == null || nums.length == 0){
                return ans;
            }
            int n = nums.length;
            func(nums, 0, n-1);
            return ans;
        }
        private void func(int[] nums, int start, int end){
            if(start == end){
                List<Integer> tem = new ArrayList<>();
                for(int num : nums){
                    tem.add(num);
                }
                ans.add(tem);
                return;
            }
            for(int i = start; i <= end; i ++){
                swap(nums, i, start);
                func(nums, start + 1, end);
                swap(nums, i, start);
            }
        }
        private void swap(int[] nums, int a, int b){
            int te = nums[a];
            nums[a] = nums[b];
            nums[b] = te;
        }
    }
}
