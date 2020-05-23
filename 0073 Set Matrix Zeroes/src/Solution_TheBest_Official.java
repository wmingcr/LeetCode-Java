public class Solution_TheBest_Official {

    // mark first number to be 0, if one column or row has 0s

    class Solution {
        public void setZeroes(int[][] matrix) {
            // validity
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return;
            }
            boolean firstCol = false;
            // get lengths
            int R = matrix.length;
            int C = matrix[0].length;

            for(int r = 0; r < R; r ++){
                // check first column, firstCol is true meaning that first column should
                // be updated to 0s
                if(matrix[r][0] == 0){
                    firstCol = true;
                }

                for(int c = 1; c < C; c ++){
                    if(matrix[r][c] == 0){
                        matrix[r][0] = 0;
                        matrix[0][c] = 0;
                    }
                }
            }
            // update 0s
            for(int r = 1; r < R; r ++){
                for(int c = 1; c < C; c ++){
                    if(matrix[r][0] == 0 || matrix[0][c] == 0){
                        matrix[r][c] = 0;
                    }
                }
            }
            // first row
            if(matrix[0][0] == 0){
                for(int c = 0; c < C; c ++){
                    matrix[0][c] = 0;
                }
            }
            // first column
            if(firstCol){
                for(int r = 0; r < R; r ++){
                    matrix[r][0] = 0;
                }
            }
        }
    }
}
