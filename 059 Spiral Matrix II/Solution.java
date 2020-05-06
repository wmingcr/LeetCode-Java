class Solution {
    public int[][] generateMatrix(int n) {
        
        // validity
        if(n <= 0){
            return new int[0][0];
        }
        
        int[][] ans = new int[n][n];
        
        int left = 0, right = n-1, top = 0, bottom = n-1, idx = 1;
        
        while(true){
            
            //top row
            for(int c = left; c <= right; c++){
                ans[top][c] = idx++;
            }
            
            if(++top > bottom) break;
            
            //right column
            for(int r = top; r <= bottom; r++){
                ans[r][right] = idx++;
            }
            
            if(--right < left) break;
            
            //bottom row
            for(int c = right; c >= left; c--){
                ans[bottom][c] = idx++;
            }
            
            if(--bottom < top) break;
            
            //left column
            for(int r = bottom; r >= top; r--){
                ans[r][left] = idx++;
            }
            
            if(++left > right) break;
        }
        return ans;
    }
}
