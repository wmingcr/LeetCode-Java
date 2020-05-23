public class Solution_mnSpace {

    // worst space complexity and time complexity,
    // like brute force,
    // Time Complexity, O( m*n + m*n*(m+n) )
    // Space Complexity, O( m*n )
    class Solution {
        public void setZeroes(int[][] matrix) {
            // validity
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return;
            }

            // get lengths
            int m = matrix.length;
            int n = matrix[0].length;
            // new array to store status of matrix
            boolean[][] arr = new boolean[m][n];
            for(int i = 0; i < m; i ++){
                for(int j = 0; j < n; j ++){
                    if(matrix[i][j] == 0){
                        arr[i][j] = true;
                    }
                }
            }
            // change value to 0s
            for(int i = 0; i < m; i ++){
                for(int j = 0; j < n; j ++){
                    if(arr[i][j]){
                        setZero(matrix, i, j);
                    }
                }
            }
        }
        private void setZero(int[][] matrix, int i, int j){
            for(int k = 0; k < matrix[0].length; k++){
                matrix[i][k] = 0;
            }
            for(int k = 0; k < matrix.length; k ++){
                matrix[k][j] = 0;
            }
        }
    }
}
