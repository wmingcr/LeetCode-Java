public class Solution_DP {

    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] arr = new int[m][n];
            for(int i = 0; i < m; i ++){
                for(int j = 0; j < n; j ++){
                    // first row or column
                    if(i == 0 || j == 0){
                        arr[i][j] = 1;
                        continue;
                    }
                    arr[i][j] = arr[i][j-1] + arr[i-1][j];
                }
            }
            return arr[m-1][n-1];
        }
    }
}
