class Solution {
    public int maxArea(int[] height) {
        //validity
        if(height == null || height.length < 2){
            return 0;
        }
        int maxArea = 0;
        for(int i = 0; i < height.length-1; i ++){
            for(int j = i+1; j < height.length; j++){
                maxArea = Math.max(maxArea, (j-i)*Math.min(height[i], height[j]));
            }
        }
        return maxArea;
    }
}
