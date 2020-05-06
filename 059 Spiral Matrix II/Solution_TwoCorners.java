class Solution {
    public int[][] generateMatrix(int n) {
        //validity
        if(n <= 0){
            return new int[0][0];
        }
        
        int[][] ans = new int[n][n];
        
        int t = 0, l = 0, r = n-1, b = n-1, idx = 1, all = n*n;
        
        while(idx <= all){
            
            for(int i = l; i < r && idx <= all; i ++){
                ans[t][i] = idx++;
            }
            for(int i = t; i <= b && idx <= all; i ++){
                ans[i][r] = idx++;
            }
            if(t < b && l < r){
                for(int i = r-1; i > l && idx <= all; i --){
                    ans[b][i] = idx++;
                }
                for(int i = b; i > t && idx <= all; i --){
                    ans[i][l] = idx++;
                }
            }
            t++;
            l++;
            r--;
            b--;
        }
        return ans;
    }
}
