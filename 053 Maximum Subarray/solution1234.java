class Solution {
    public int maxSubArray(int[] nums) {
        //check validity
        if(nums == null || nums.length ==0){
            return 0;
        }
        
        //return maxSubArray2(nums);
        //Runtime: 1 ms, faster than 75.84% of Java online submissions for Maximum Subarray.
        
        //return maxSubArray3(nums);
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Subarray.
        
        return maxSubArray4From2(nums);
        //Runtime: 1 ms, faster than 75.84% of Java online submissions for Maximum Subarray.
        
        //first les brute force
        //return bruteForce(nums);
        // > 5%, O(n^2), O(1)
    }
    //Time Space: O(n), Space Time: O(1)
    private int maxSubArray3(int [] arr){
        int preSum = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(preSum > 0){
               // preSum += 
                preSum += arr[i];
                max = Math.max(max, preSum);
            }else{
                preSum = arr[i];
                max = Math.max(max, preSum);
            }
        }
        return max;
    }
    //Time Space: O(n), Space Time: O(n)
    private int maxSubArray2(int [] arr){
        int preSum = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(preSum + arr[i] > arr[i]){
                preSum += arr[i];
                if(max < preSum){
                    max = preSum;
                }
            }else{
                preSum = arr[i];
                if(max < preSum){
                    max = preSum;
                }
            }
        }
        return max;
    }
    //Time Space: O(n), Space Time: O(1)
    private int maxSubArray4From2(int [] arr){
        int [] f = new int [arr.length];
        f[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            /**if(f[i - 1] > 0){
                f[i] = f[i - 1] + arr[i];
            }else{
                f[i] = arr[i];
            }*/
            f[i] = f[i - 1] > 0 ? arr[i] + f[i - 1] : arr[i];
        }
        int max = f[0];
        for(int i = 1; i < f.length; i++){
            max = max > f[i] ? max : f[i];
        }
        return max;
    }
    
    //Time Space: O(n^2), Space Time: O(1)
    private int bruteForce(int [] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i ++){
            int temp = arr[i];
            max = temp > max ? temp : max;
            for(int j = i + 1; j < arr.length; j ++){
                temp += arr[j];
                max = temp > max ? temp : max;
            }
        }
        return max;
    }
}
