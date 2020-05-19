class Solution_DPBackward {


    // n^2, n
    public int lengthOfLIS(int[] nums) {

        //validity
        if(nums == null || nums.length == 0){
            return 0;
        }

        // array, for recording the dynamic longest increasing subsequence
        int[] dp = new int[nums.length];

        // initilizing to 1, since every element is 1 element
        for(int i = 0; i < dp.length; i++){
            dp[i] = 1;
        }


        for(int i = 0; i < nums.length; i ++){

            //initializing length
            //int maxLen = 1;

            for(int j = 0; j < i; j ++){ // No need to check i == j,
                if(nums[i] > nums[j]){
                    //maxLen = Math.max(maxLen, dp[j]+1); // get the longest length
                    dp[i] = Math.max(dp[i], dp[j]+1); // directly renew dp
                }
            }

            //dp[i] = maxLen; // renew dp array
        }

        int maxLen = dp[0]; // hold the longest number

        // find the longest subsequence from dp array
        for(int n : dp){
            if(n > maxLen){
                maxLen = n;
            }
        }

        return maxLen;
    }
}