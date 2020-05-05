class Solution {
    public void rotate(int[][] matrix) {
        //validity
        if(matrix == null || matrix.length <= 1){
            return;
        }
        
        //get length
        int len = matrix.length;
        
        //swap
        for(int i = 0; i <= (len>>1); i ++){
            for(int j = i+1; j < len-i; j ++){
                int te = matrix[i][j];
                matrix[i][j] = matrix[len-j-1][i];
                matrix[len-j-1][i] = matrix[len-i-1][len-j-1];
                matrix[len-i-1][len-j-1] = matrix[j][len-i-1];
                matrix[j][len-i-1] = te;
            }
        }
        return;
    }
}
