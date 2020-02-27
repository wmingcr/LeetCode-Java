class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //check validity
        if(nums == null || nums.length < 2 || k <= 0){
            return false;
        }
        
        //Method 1, Brute Force
        //T, O(n^2), S, O(1), Runtime: 1548 ms, faster than 5.07% 
        //return withBruteForce(nums, k);
        
        //Method 2, Opimized Brute Force
        //Only need to search within k length. Runtime: 1285 ms, faster than 6.60%, Only faster a little -_-
        //return bruteForce2(nums, k);
        
        /*Method 3, Brute Force with two pointers
        There might be a problem: with more than four duplicated elements, how to determine which dif is the smallest one?
        return bruteForce_TwoPointers();
        
        Genius, somebody got it.
        */
        //<<AWESOME*****>>
        return method3_TwoPointers(nums, k);
        
        
        //Method 4, TreeSet
        //Runtime: 22 ms, faster than 19.09%
        //return treeSetDemo(nums, k);//boolean	remove​(Object o)
        
        //Method 5, try HashSet
        //Runtime: 6 ms, faster than 81.50%
        //Same way with method 4, which means HashSet is more efficient than TreeSet.
        //return tryHashSet(nums, k);
    }
    
    private boolean method3_TwoPointers(int [] nums, int k){
        //two pointers
        int left = 0, right = 1;
        while(right < nums.length){
            if(left != right && nums[left] == nums[right]){//missing left!= right
                return true;
            }
            //keep dif within length of k
            if(right - left >= k){
                left++;
            }else{
                right ++;
            }
        }
        right -- ;
        //left is still less than right about k
        while(left < right){
            if(nums[left] == nums[right])
                return true;
            left++;
        }
        return false;
    }
    
    private boolean tryHashSet(int [] nums, int k){
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < nums.length; i ++){
            if(hs.contains(nums[i])){
                return true;
            }
            hs.add(nums[i]);
            if(hs.size() > k){
                hs.remove(nums[i - k]);
            }
        }
        return false;
    }
    
    private boolean treeSetDemo(int [] nums, int k){
        Set<Integer> st = new TreeSet<>();
        for(int i = 0; i < nums.length; i ++){
            if(st.contains(nums[i])){
                return true;
            }
            st.add(nums[i]);
            if(st.size() > k){
                st.remove(nums[i - k]);
            }
        }
        return false;
    }
    
    private boolean bruteForce2(int [] nums, int k){
        for(int i = 0; i < nums.length; i ++){
            for(int j = i + 1; j <= i + k && j < nums.length; j ++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean bruteForce_TwoPointers(int [] nums, int k){
        for(int i = 0; i < nums.length; i ++){
            int lef = i, rig = nums.length - 1;
            for(int j = i + 1; j < nums.length - 1; j ++){
                lef++;
                rig--;
            }
        }
        return false;
    }
    
    private boolean withBruteForce(int [] nums, int k){
        for(int i = 0; i < nums.length; i ++){
            int lef = i, rig = Integer.MAX_VALUE;
            for( int j = i + 1; j < nums.length; j ++){
                if(nums[j] == nums[i]){
                    lef = rig > nums.length ? lef : rig;
                    rig = j;
                }
                if(rig - lef <= k)
                    return true;
            }
        }
        return false;
    }
}
