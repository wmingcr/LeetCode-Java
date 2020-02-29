class Solution {
    public static int missingNumber(int[] nums) {
    	int res = 0;
    	// 0~n-1 异或了整个数组，还差n再异或一次
    	for(int i = 0; i <= nums.length-1; i++){
    		res ^= i ^ nums[i];
    	}
    	return nums.length^res;
    }
}
