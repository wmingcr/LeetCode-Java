public class Solution_DummyValue {

    // This method might not be a good approach,
    // Since MODIFIED value maybe conflict with any values from matrix


    class Solution {
        public void setZeroes(int[][] matrix) {
            // validity
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return;
            }
            // dummy value
            final int MODIFIED = -1_000_000_000;
            // get lengths
            int R = matrix.length;
            int C = matrix[0].length;

            for(int r = 0; r < R; r++){
                for(int c = 0; c < C; c++){
                    if(matrix[r][c] == 0){
                        for(int k = 0; k < C; k ++){
                            if(matrix[r][k] != 0){
                                matrix[r][k] = MODIFIED;
                            }
                        }
                        for(int k = 0; k < R; k ++){
                            if(matrix[k][c] != 0){
                                matrix[k][c] = MODIFIED;
                            }
                        }
                    }
                }
            }

            for(int r = 0; r < R; r ++){
                for(int c = 0; c < C; c ++){
                    if(matrix[r][c] == MODIFIED){
                        matrix[r][c] = 0;
                    }
                }
            }
        }
    }
}
