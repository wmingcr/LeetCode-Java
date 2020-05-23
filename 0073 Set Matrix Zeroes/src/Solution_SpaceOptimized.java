public class Solution_SpaceOptimized {

    // using two arrays, arr with length m, brr with length n to store status of matrix
    // then change specific rows and cols to 0s,

    // time complexity, O(3*m*n)
    // space complexity, O(m + n);

    class Solution {
        public void setZeroes(int[][] matrix) {
            // validity
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return;
            }

            // get lengths
            int m = matrix.length;
            int n = matrix[0].length;
            // to record status of matrix (whether there are 0s)
            boolean[] rows = new boolean[m];
            boolean[] cols = new boolean[n];
            // find 0s
            for(int i = 0; i < m; i ++){
                for(int j = 0; j < n; j ++){
                    if(matrix[i][j] == 0){
                        rows[i] = true;
                        cols[j] = true;
                    }
                }
            }
            // set 0s for rows
            for(int i = 0; i < m; i ++){
                if(rows[i]){
                    setZero(i, matrix);
                }
            }
            // set 0s for cols
            for(int i = 0; i < n; i ++){
                if(cols[i]){
                    setZero(matrix, i);
                }
            }
        }

        private void setZero(int[][] matrix, int i){
            for(int k = 0; k < matrix.length; k ++){
                matrix[k][i] = 0;
            }
        }

        private void setZero(int i, int[][] matrix){
            for(int k = 0; k < matrix[0].length; k ++){
                matrix[i][k] = 0;
            }
        }
    }
}
