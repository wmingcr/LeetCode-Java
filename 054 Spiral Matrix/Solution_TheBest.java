//see https://leetcode-cn.com/problems/spiral-matrix/solution/cxiang-xi-ti-jie-by-youlookdeliciousc-3/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans = new LinkedList<>();
        
        //validity
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return ans;
        }
        
        int m = matrix.length, n = matrix[0].length;
        
        int left = 0, right = n-1, top = 0, bottom = m-1;
        
        while(true){
            
            //up row
            for(int c = left; c <= right; c ++){
                ans.add(matrix[top][c]);
            }
            
            if(++top > bottom) break;
            
            //right column
            for(int r = top; r <= bottom; r ++){
                ans.add(matrix[r][right]);
            }
            
            if(--right < left) break;
            
            //bottom row
            for(int c = right; c >= left; c --){
                ans.add(matrix[bottom][c]);
            }
            
            if(--bottom < top) break;
            
            //left column
            for(int r = bottom; r >= top; r --){
                ans.add(matrix[r][left]);
            }
            
            if(++left > right) break;
        }
        return ans;
    }
}
