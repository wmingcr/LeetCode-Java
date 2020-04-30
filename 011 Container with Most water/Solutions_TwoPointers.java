## Two Pointers, reduce search area

/**reference https://www.cxyxiaowu.com/9292.html

For two pointers, even more, while left == right, we can skip left and right together, see : https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/

*/
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
                i++;
            }else{
                j--;
            }
        }
        return mostWater;
    }
}
