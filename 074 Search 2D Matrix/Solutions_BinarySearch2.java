class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //validity
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        
        int up = 0, down = matrix.length-1, row = 0;
        while(up <= down){
            int mid = up + ((down-up)>>1);
            if(target < matrix[mid][0]){
                down = mid-1;
            }else if (target > matrix[mid][0]){
                up = mid + 1;
            }else{
                return true;
            }
        }
        //incase already out of bound 
        if(up > matrix.length || down < 0){
            return false;
        }
        
        row = up-1;
        int left = 0, right = matrix[0].length-1, col = 0;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            if(target < matrix[row][mid]){
                right = mid - 1;
            }else if (target > matrix[row][mid]){
                left = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
