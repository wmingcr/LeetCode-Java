//TC, O(lg(m*n)), SC, O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //binary search
        //validity
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        for(int i = 0, j = row*col-1; i <= j; ){
            int mid = i + ((j-i)>>1);
            int r = mid/matrix[0].length;
            int c = mid%matrix[0].length;
            if(matrix[r][c] > target){
                j = mid - 1;
            }else if (matrix[r][c] < target){
                i = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
