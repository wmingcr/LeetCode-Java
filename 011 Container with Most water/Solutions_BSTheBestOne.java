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


//-------The Best Submission 
//Here height[i] is the height of wall and 2 contigious heights (height[i], height[i+1] are separated by 1 unit)
class Solution {
    public int maxArea(int[] height) {
		//we start with 2 pointers at the 2 ends assuming that the width between the 2 walls/heights being the maximum, area could be maximum.
		//Note that the area in this case would be width * (shorter wall height)
		//We then shrink the shorter height/wall closer and recalculate area and check if this is more than maxArea
        int start=0, end=height.length-1;
        int maxArea = 0;
        while(start<end) {
            int area = Math.min(height[start], height[end]) * (end-start);
            maxArea = Math.max(maxArea,area);
            //System.out.println("start = "+start+" End = "+end+" area = "+area+" maxArea = "+ maxArea);
            if(height[start] > height[end] && start<end) {
                int currHeight = height[end];
                while(height[--end]<=currHeight) ;
                //end--;
            }
            else {
                int currHeight = height[start];
                while(height[++start] <= currHeight && start<end) ;
                //start++;
            }
        }
        return maxArea;
    }
}
