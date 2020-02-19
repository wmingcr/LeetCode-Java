class Solution {
    public int[] twoSum(int[] nums, int target) {
        //check validity
        if(nums == null || nums.length <2){
            return new int [] {-1, -1};
        }
        
        //85.93%, O(n), O(n)
        //return traverseTwiceHashMap(nums, target);
        
        //traverse HashMap only once
        //Runtime: 1 ms, faster than 99.90% of Java online submissions for Two Sum.
        return traverseOnceHashMap(nums, target);
        
    }
    
    private int[] traverseOnceHashMap(int [] arr, int target){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int dif = target - arr[i];
            if(hm.containsKey(dif))
                return new int [] {i, hm.get(dif)};
            //在放进去之前，先进行判断，这样如果存在该元素，则肯定不是本元素
            hm.put(arr[i], i);
        }
        return new int [] {-1, -1};
    }
    
    private int [] traverseTwiceHashMap(int [] arr, int target){
        //store in a HashMap
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            hm.put(arr[i], i);
        }
        //find the pair
        for(int i = 0; i < arr.length; i++){
            int dif = target - arr[i];
            if(hm.containsKey(dif) && hm.get(dif) != i){
                return new int [] {i, hm.get(dif)};
            }
        }
        return new int [] {-1, -1};
    }
}
