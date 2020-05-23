public class Solution_DPOptimized {

    /**
     *  we can just modify data in place, so space complexity could be reduced to O(1)
     */

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            // validity
            if( obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
                return 0;
            }
            // the most important data is the first row and first conlumn
            // get lengths
            int m = obstacleGrid.length, n = obstacleGrid[0].length;

            // instead of creating a new grid, we can just modify values in place
            if(obstacleGrid[0][0] == 1){
                return 0;
            }

            obstacleGrid[0][0] = 1;

            // first column
            for(int i = 1; i < m; i ++){
                if(obstacleGrid[i][0] == 1){
                    obstacleGrid[i][0] = 0;
                } else {
                    obstacleGrid[i][0] = obstacleGrid[i-1][0] == 0 ? 0 : 1;
                }
            }
            // first row
            for(int i = 1; i < n; i ++){
                if(obstacleGrid[0][i] == 1){
                    obstacleGrid[0][i] = 0;
                } else {
                    obstacleGrid[0][i] = obstacleGrid[0][i-1] == 0 ? 0 : 1;
                }
            }

            // dynamic programming
            for(int i = 1; i < m; i ++){
                for(int j = 1; j < n; j ++){
                    if(obstacleGrid[i][j] == 1){
                        obstacleGrid[i][j] = 0;
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                    }
                }
            }
            return obstacleGrid[m-1][n-1];
        }
    }
}
