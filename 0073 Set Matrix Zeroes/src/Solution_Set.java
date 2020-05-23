import java.util.HashSet;
import java.util.Set;

public class Solution_Set {

    class Solution {
        public void setZeroes(int[][] matrix) {
            // validity
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return;
            }

            // get lengths
            int r = matrix.length;
            int c = matrix[0].length;

            // get sets
            Set<Integer> rows = new HashSet<> ();
            Set<Integer> cols = new HashSet<>();
            // find rows and columns which have 0s
            for(int i = 0; i < r; i ++){
                for(int j = 0; j < c; j ++){
                    if(matrix[i][j] == 0){
                        rows.add(i);
                        cols.add(j);
                    }
                }
            }
            // set 0s
            for(int i = 0; i < r; i ++){
                for(int j = 0; j < c; j ++){
                    if(rows.contains(i) || cols.contains(j)){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
