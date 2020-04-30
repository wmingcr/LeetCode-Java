class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //validity
        if(matrix == null || matrix.length == 0){
            return false;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        for(int i = 0, j = col-1; i < row && j >= 0; ){
            if(matrix[i][j] == target){
                return true;
            }else if (matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
