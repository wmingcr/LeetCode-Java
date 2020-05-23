public class Solution_DP {

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            // validity
            if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
                return 0;
            }
            // the most important data is the first row and first conlumn
            // get lengths
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            // new array, for dp
            int[][] arr = new int[m][n];



            // // filling 1s
            // int fillingNum = 1;
            // for(int i = 0; i < m; i ++){
            //     if(obstacleGrid[i][0] == 1){
            //         fillingNum = 0;
            //     }
            //     arr[i][0] = fillingNum;
            // }
            // fillingNum = 1;
            // for(int i = 0; i < n; i ++){
            //     if(obstacleGrid[0][i] == 1){
            //         fillingNum = 0;
            //     }
            //     arr[0][i] = fillingNum;
            // }

            // default value is 0s, even if filling nothing, for first row and conlumn
            // we don't fill anything when facing a 1
            for(int i = 0; i < m && obstacleGrid[i][0] == 0; i ++){
                arr[i][0] = 1;
            }
            for(int i = 0; i < n && obstacleGrid[0][i] == 0; i ++){
                arr[0][i] = 1;
            }

            // dynamic programming
            for(int i = 1; i < m; i ++){
                for(int j = 1; j < n; j ++){
                    arr[i][j] = obstacleGrid[i][j] == 1 ? 0 : arr[i-1][j] + arr[i][j-1];
                }
            }
            return arr[m-1][n-1];
        }
    }
}
