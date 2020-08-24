public class MySolution {
    class Solution {
        public int trap(int[] height) {
            // corner case
            if(height == null || height.length < 3){
                return 0;
            }

            int res = 0, n = height.length;

            for(int i = 0; i < n-1; ){
                int j = i+1, nextMaxIdx = j;
                while(j < n){
                    if(height[j] > height[i]){
                        break;
                    } else {
                        if(height[j] > height[nextMaxIdx]){
                            nextMaxIdx = j;
                        }
                    }
                    j++;
                }
                if(j < n){
                    res += getRain(height, i, j);
                    i = j;
                } else {
                    res += getRain(height, i, nextMaxIdx);
                    i = nextMaxIdx;
                }
            }

            return res;
        }

        private int getRain(int[] height, int L, int R){
            int fence = Math.min(height[L], height[R]), res = 0;
            for(int i = L + 1; i < R; i ++){
                res += Math.max(0, fence - height[i]);
            }
            return res;
        }
    }
}
