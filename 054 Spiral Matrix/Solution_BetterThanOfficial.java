//also see this C++ version
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans = new LinkedList<>();
        
        //validity
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return ans;
        }
        
        int m = matrix.length, n = matrix[0].length;
        
        int left = 0, right = n-1, top = 0, bottom = m-1;
        
        int sum = m*n;
        
        while(ans.size() < sum){
            
            //up row
            for(int c = left; c <= right && ans.size() < sum; c ++){
                ans.add(matrix[top][c]);
            }
            
            top++;
            
            //right column
            for(int r = top; r <= bottom && ans.size() < sum; r ++){
                ans.add(matrix[r][right]);
            }
            
            right--;
            
            //bottom row
            for(int c = right; c >= left && ans.size() < sum; c --){
                ans.add(matrix[bottom][c]);
            }
            
            bottom--;
            
            //left column
            for(int r = bottom; r >= top && ans.size() < sum; r --){
                ans.add(matrix[r][left]);
            }
            
            left++;
        }
        return ans;
    }
}
