public class TheBestBinarySearchSolution {

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println (new Solution().lengthOfLIS (arr));
        System.out.println (new Solution1().lengthOfLIS (arr));
    }

    static class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int res = 0, lo, hi, mid;
            int[] tail = new int[n];
            for(int num : nums){
                lo = 0;
                hi = n-1;
                while(lo < hi){
                    mid = lo + (hi - lo) / 2;
                    if(tail[mid] < num){
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                tail[lo] = num;
                if(res == lo){
                    res++;
                }
            }
            return res;
        }
    }

    static class Solution1 {
        public int lengthOfLIS(int[] nums) {
            int[] tails = new int[nums.length];
            int size = 0;
            for (int x : nums) {
                int i = 0, j = size;
                while (i != j) {
                    int m = (i + j) / 2;
                    if (tails[m] < x)
                        i = m + 1;
                    else
                        j = m;
                }
                tails[i] = x;
                if (i == size) ++size;
            }
            return size;
        }
    }

}
