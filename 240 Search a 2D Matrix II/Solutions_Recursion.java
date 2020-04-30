//divide the matrix into four parts, two parts definitely don't contain the target
//the other two parts might contain the target
//https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-by-leetcode-2/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //validity
        if(matrix == null || matrix.length == 0){
            return false;
        }
        
        return search(0, 0, matrix[0].length-1, matrix.length-1, matrix, target);
    }
    
    private boolean search(int left, int up, int right, int down, int[][] matrix, int target){
        //ending conditions
        if(left > right || up > down){
            return false;
        }else if (target < matrix[up][left] || target > matrix[down][right]){
            return false;
        }
        
        int mid = left + ((right-left)>>1);
        
        int row = up;
        while(row <= down && matrix[row][mid] <= target){
            if(matrix[row][mid] == target){
                return true;
            }
            row++;
        }
        
        return search(left, row, mid-1, down, matrix, target) || search(mid+1, up, right, row-1, matrix, target);
    }
}
