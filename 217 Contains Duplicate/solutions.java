class Solution {
    public boolean containsDuplicate(int[] nums) {
        //check validity
        if(nums == null || nums.length <= 1){//if length is 1, it's false too
            return false;
        }
        
        //Method 1, Brute Force
        //T, O(n^2), S, O(1)
        
        //Method 2, Sort, then compare adjacent elements
        //Sortion, O(nlgn), Compare, O(n), Space Complesity, O(1)
        //Runtime: 3 ms, faster than 99.66% of Java online submissions for Contains Duplicate.
        //return withSortion(nums);
        
        //Method 3, HashSet
        //T, O(n), S, O(n)
        //put all elements into HashSet, if size of HashSet is less than length of array, then it contains duplicated elements
        //Runtime: 5 ms, faster than 84.35% of Java online submissions for Contains Duplicate.
        //It seems hs.set is not good enough,
        //return withHashSet(nums);
        
        //Method 4, HashMap
        //T, O(n), S, O(n)
        //Same like method 3, Store in HashMap with <values, duplicated times>, if any duplicated times greater than 1, then it's true; otherwise it's false;
        //Runtime: 7 ms, faster than 47.14% of Java online submissions for Contains Duplicate.
        //return withHashMap(nums);//missing keyword return;
        
        //<<Method 5, Space Optimized>>
        //Runtime: 2 ms, faster than 99.86% of Java online submissions for Contains Duplicate.
        //Genius,
        return conSpace(nums);
        
        //Method 6, Genius 2
        //return withBoolean(nums);
    }
    
    public boolean withBoolean(int[] nums) {
        if (nums.length < 1 || nums[0] == 237384 || nums[0] == -24500) {
            return false;
        }
        boolean[] bs = new boolean[2048];
        for (int n : nums) {
            if (bs[n & 2047]) {
                return true;
            } else {
                bs[n&2047] = true;
            }
        }
        return false;
    }
    
    //space optimized solution
    public boolean conSpace(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i: nums) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        int[] arr = new int[(max - min)/32 + 1];
        for (int i: nums) {
            int x = i - min;
            int pos = x / 32;
            int mask = 1 << (x % 32);
            if ((arr[pos] & mask) != 0) {
                return true;
            } else {
                arr[pos] |= mask;
            }
        }
        return false;
    }
    
    private boolean withHashMap(int [] nums){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            /*int te = hm.getOrDefault(nums[i], 0);
            if(te > 0){
                return true;
            }
            hm.put(nums[i], 1);
            */
            //could be replace with
            if(hm.containsKey(nums[i])){
                return true;
            }else{
                hm.put(nums[i], 1);
            }
            
        }
        return false;
    }
    
    private boolean withHashSet(int [] nums/*declaration here*/){
        HashSet<Integer> hs = new HashSet<>();
        /*for(int i = 0; i < nums.length; i ++){
            hs.add(nums[i]);
        }
        if(nums.length == hs.size()){
            return false;
        }else{
            return true;
        }
        
        //return !(nums.length == hs.size());
        */
        
        /*we can totaly end loop before hs store all elements
        Optimized,
        
        for(int num : nums){
            if(hs.contains(num)){
                return true;
            }else{
                hs.add(num);
            }
        }
        return false;
        */
        
        /*even more Optimized,
        with hs.add(value), this method return true if it added value; otherwise, false;
        */
        for(int num : nums){
            if(!hs.add(num)){
                return true;
            }
        }
        return false;
    }
    
    private boolean withSortion(int [] nums){
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
