//official answer, https://leetcode.com/problems/spiral-matrix/solution/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //initialization
        List<Integer> ans = new LinkedList<>();
        
        //validity
        if(matrix == null || matrix.length == 0){
            return ans;
        }
        
        //left, top corner
        int r1 = 0, c1 = 0;
        //right bottom corner
        int r2 = matrix.length-1, c2 = matrix[0].length-1;
        
        while(r1 <= r2 && c1 <= c2){
            //top row
            for(int c = c1; c <= c2; c++){
                ans.add(matrix[r1][c]);
            }
            //right column
            for(int r = r1+1; r <=r2; r++){
                ans.add(matrix[r][c2]);
            }
            
            if(r1 < r2 && c1 < c2){
                //bottom row
                for(int c = c2-1; c > c1; c--){
                    ans.add(matrix[r2][c]);
                }
                //left column
                for(int r = r2; r > r1; r--){
                    ans.add(matrix[r][c1]);
                }
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }
        
        return ans;
    }
}
