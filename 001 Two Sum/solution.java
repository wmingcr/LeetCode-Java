class Solution {
    public int[] twoSum(int[] nums, int target) {
        //check status of array
        if(nums == null || nums.length <= 0){
            return null;
        }
        //using HashMap,
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            hm.put(nums[i], i);
        }
        //a for loop to check whether the pair of num exist
        for(int i = 0; i < nums.length; i++){
            int key = target - nums[i];
            if(hm.containsKey(key) && i != hm.get(key)){
                return new int [] {i, hm.get(key)};
            }
        }
        return null;
    }
}
