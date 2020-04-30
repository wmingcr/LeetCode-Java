//continue optimize the smaller side
//1. optimize, while left wall == right wall, we skip both walls together, i++, j--
//2. optimize, see while inside of for loop. if after i++/j--, the inner value is still smaller than former one, we just skip it. 
//Reference, see 1 ms submission for this problem.
class Solution {
    public int maxArea(int[] height) {
        //validity
        if(height == null || height.length < 2){
            return 0;
        }
        
        int mostWater = 0;
        for(int i = 0, j = height.length-1; i < j; ){
            mostWater = Math.max(mostWater, (j-i)*Math.min(height[i], height[j]));
            
            if(height[i] < height[j]){
                int te = height[i];
                while(height[++i] <= te){ }
            }else if (height[i] > height[j]){
                int te = height[j];
                while(height[--j] <= te){ }
            }else{
                i++;
                j--;
            }
        }
        return mostWater;
    }
}
