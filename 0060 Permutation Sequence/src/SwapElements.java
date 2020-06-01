public class SwapElements {

    // this method could get an answer, however it's not the sequence
    // which the problem requires

    class Solution {
        String ans = "";
        int ith = 0;
        public String getPermutation(int n, int k) {
            int[] nums = new int[n];
            for(int i = 0; i < n; i ++){
                nums[i] = i+1;
            }
            backtrack(0, n-1, nums, k);
            return ans;
        }
        private void backtrack(int start, int end, int[] nums, int k){
            if(start == end){
                ith ++;
                if(ith == k){
                    for(int i = 0; i <= end; i ++){
                        ans += nums[i];
                    }
                }
                return;
            }
            for(int i = start; i <= end; i ++){
                if (ith == k){
                    break;
                }
                swap(nums, i, start);
                backtrack(start+1, end, nums, k);
                swap(nums, i, start);
            }
        }
        private void swap(int[] arr, int i, int j){
            int te = arr[i];
            arr[i] = arr[j];
            arr[j] = te;
        }
    }
}
