import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] arr = {3,5,2,1,6,4};
        new Solution ().wiggleSort (arr);
    }

    static class Solution {
        public void wiggleSort(int[] nums) {
            // corner case
            if(nums == null || nums.length == 0){
                return;
            }

            int n = nums.length;
            int[] copy = Arrays.copyOf(nums, n);
            Arrays.sort(copy);
            int L = 0, R = n-1, idx = 0;
            while(L <= R){
                nums[idx] = idx++ % 2 == 0 ? copy[L++] : copy[R--];
            }
        }
    }
}
