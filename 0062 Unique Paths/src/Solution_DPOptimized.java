public class Solution_DPOptimized {

    // reduce space complexity from O(m * n) to O(min(m, n))
    class Solution {
        public int uniquePaths(int m, int n) {
            // validity
            if(m <= 0 || n <= 0){
                return 0;
            }
            // array with length n;
            int[] arr = new int[n];
            // filling 1
            for(int i = 0; i < n; i ++){
                arr[i] = 1;
            }
            // update steps, dynamic programming
            for(int i = 1; i < m; i++){
                for(int j = 1; j < n; j++){
                    arr[j] += arr[j - 1];
                }
            }
            return arr[n - 1];
        }
    }
}
