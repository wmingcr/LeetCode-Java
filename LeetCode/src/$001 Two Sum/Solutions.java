class Solution {
    public int[] twoSum(int[] nums, int target) {
        //return solution1(nums, target);
        return solution2(nums, target);
        //return for2for(int[] nums, int target);
    }
    
    /*
    two pass HashMap, store and traverse 
    */
    private int [] solution2(int[] nums, int target){
        //check validity
        if(nums == null || nums.length < 2){
            return null;
        }
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        //store values into map
        for(int i = 0; i < nums.length; i ++){
            hm.put(nums[i], i);
        }
        
        for(int i = 0; i < nums.length; i ++){
            int num2 = target - nums[i];
            if(hm.containsKey(num2) && hm.get(num2) != i){
                return new int [] {i, hm.get(num2)};
            }
        }
        return null;
    }
    
    /**
     * TC, n; SC, n
     * one pass HashMap
     * https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/
     * https://leetcode.com/problems/two-sum/solution/
     */
    private int[] solution1(int[] nums, int target){
        //check validity of nums
        if(nums == null || nums.length < 2){
            return new int[]{};
        }
        //using map to store all values, mainly for hashCode
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        //O(n)
        for(int i = 0; i < nums.length; i ++){
            int num2 = target - nums[i];
            /*
            if(hm.containsKey(num2) && hm.get(num2) != i){
                return new int [] {i, hm.get(num2)};
            }
            */
            //i is not stored inside yet, so:
            if(hm.containsKey(num2)){
                return new int [] {i, hm.get(num2)} ;
            }
            hm.put(nums[i], i);
        }
        return null;
    }
}
