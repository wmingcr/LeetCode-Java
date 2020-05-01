class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //validity
        if(nums == null || nums.length < 3){
            return -1;
        }
        
        //sort the array
        Arrays.sort(nums);
        
        //initialization
        int ans = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length-2; i ++){
            //skip duplicate elements
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            
            //two pointers
            int m = i+1, k = nums.length-1;
            while(m < k){
                //sum of three elements
                int sum = nums[i] + nums[m] + nums[k];
                
                //check new abs
                if(Math.abs(target - sum) < Math.abs(target - ans)){
                    ans = sum;
                }
                
                if(sum < target){
                    m++;
                }else if (sum > target){
                    k--;
                }else{
                    return ans;
                }
            }
        }
        return ans;
    }
}
