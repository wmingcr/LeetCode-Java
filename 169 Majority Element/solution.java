class Solution {
    public int majorityElement(int[] nums) {
        //check validity
        if(nums == null || nums.length == 0){
            return 0;
        }
        //Method 1, 
        //Brute Force
        
        //Method 2, 
        //HashMap, not good enough
        //T, O(n), S, O(n)
        //Runtime: 7 ms, faster than 49.50% of Java online submissions for Majority Element.
        //return withHashMap(nums);
        
        //Method 3,
        //Sort, return nums[nums.length/2]
        //Runtime: 1 ms, faster than 99.85% of Java online submissions for Majority Element.
        //T, O(nlgn), S, O(1)
        //Arrays.sort(nums);
        //return nums[nums.length/2];
        
        //Method 4, Boyer Moore voting, concise, EXCELLENT,
        //T, O(n), S, O(1)
        //return boyerMooreVoting(nums);
        //return boyerMooreVoting2(nums);
        //return boyerMooreVoting3(nums); //---> Most Excellent,
        
        //Method 5, Binary
        //T, O(32n), S, O(1)
        //If it's majority, then in every bits it is majority
        //Runtime: 4 ms, faster than 52.83% of Java online submissions for Majority Element.
        //return withBinary(nums);
    }
    
    private int withBinary(int [] nums){
        int ans = 0; 
        for(int i = 1, mask = 1; i <= 32; i++, mask <<= 1){
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                count += (mask & nums[j]) != 0 ? 1 : 0;
            }
            if(count > nums.length/2){
                ans = mask | ans;
            }
        }
        return ans;
    }
    
    private int boyerMooreVoting3(int [] nums){
        int ans = nums[0], count = 0;
        for(int num : nums){
            if(ans == num){
                count ++; 
            }else if(--count == 0){
                ans = num;
                count = 1;
            }
        }
        return ans;
    }
    
    private int boyerMooreVoting2(int [] nums){
        Integer ans = null;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                ans = nums[i];
            }
            count += nums[i] == ans ? 1 : -1;
        }
        return ans;
    }
    
    private int boyerMooreVoting(int [] nums){
        Integer ans = null;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                ans = nums[i];
                count ++;
            }else{
                if(ans == nums[i]){
                    count ++;
                }else{
                    
                    count -- ;
                }
            }
        }
        return ans;
        
        /**
        * ugly block code,
        int ans = nums[0], count = 1;
        for(int i = 1; i < nums.length; i++){
            //i+1 might be out of bound
            if(nums[i] == ans){
                count ++;
            }else{
                count --;
                if(count == 0){
                    ans = nums[i+1];
                    i++;
                    count = 1;
                }
            }
        }
        return ans;
        */
    }
    
    private int withHashMap(int[] nums){
        //store values and duplicate times,
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            /**
            if(hm.containsKey(nums[i])){
                hm.put(nums[i], hm.get(nums[i]) + 1);
            }else{
                hm.put(nums[i], 1);
            }
            if(hm.get(nums[i]) > nums.length/2){
                return nums[i];
            }
            */
            // or,
            int count = hm.getOrDefault(nums[i], 0) + 1;
            hm.put(nums[i], count);
            if(count > nums.length/2){
                return nums[i];
            }
        }
        return 0;
    }
}
