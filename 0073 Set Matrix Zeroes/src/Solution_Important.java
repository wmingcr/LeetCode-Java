public class Solution_Important {

    class Solution {
        public void setZeroes(int[][] matrix) {

            /**
             the problem for turning negatives to positives is not practical
             Like, if there are negatives and don't have 0s,

             */



            // validity
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return;
            }

            // get lengths
            int m = matrix.length;
            int n = matrix[0].length;

            // for this approach, we are trying to change positive values to negative
            // if there is a 0,
            // at the end, we change all 0s and negative nubmers to 0s

            // pre-process data, to make sure every element is non negative
            // find 0s, marks that row and col to negative numbers

            // for(int i = 0; i < m; i ++){
            //     for(int j = 0; j < n; j ++){
            //         if(matrix[i][j] < 0){
            //             matrix[i][j] = 1;
            //         }
            //     }
            // }

            // It turns out that this method is totally wrong.
            // turning all negatives to positive, there might be no 0s



            // find 0s, marks that row and col to negative numbers
            for(int i = 0; i < m; i ++){
                for(int j = 0; j < n; j ++){
                    if(matrix[i][j] == 0){
                        markNegative(matrix, i, j);
                    }
                }
            }
            // change all 0s and negative numbers to 0s
            for(int i = 0; i < m; i ++){
                for(int j = 0; j < n; j ++){
                    if(matrix[i][j] < 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        private void markNegative(int[][] matrix, int i, int j){
            for(int k = 0; k < matrix.length; k ++){
                if(matrix[k][j] > 0){
                    matrix[k][j] *= -1;
                }
                //matrix[k][j] *= -1;
            }
            for(int k = 0; k < matrix[0].length; k ++){
                if(matrix[i][k] > 0){
                    matrix[i][k] *= -1;
                }

                // The following is wrong, marking it as a WARNING for myself
                // since we pro-processed all elements to non negatives
                // so there is no need to check whether that element is negative or not
                //matrix[i][k] *= -1;
            }
        }
    }
}
