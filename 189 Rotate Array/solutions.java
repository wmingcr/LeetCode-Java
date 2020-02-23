class Solution {
    public void rotate(int[] nums, int k) {
        //check validity
        if(nums == null || nums.length <= 0 || k <= 0){
            return;
        }
        k = k % nums.length;
        //Method 1, brute force
        //T, O(kn), S, O(1). Not good
        //Runtime: 207 ms, faster than 6.86% of Java online submissions for Rotate Array.
        //withBruteForce(nums, k);
        
        //Method 2, New array, 
        //Directly move it with K positions
        //T, O(n), S, O(n), not good enough
        //Runtime: 1 ms, faster than 48.67% of Java online submissions for Rotate Array.
        withNewArrayStoringElements(nums, k);
        
        //------------------only work for several examples------------
        //Method 3, In-place
        ////T, O(n), S, O(1)
        //with a third variable, to replace it one by one,
        //withInPlace(nums, k);
        
        //Method 4, reverse,
        //T, O(n), S, O(1)
        //EXCELLENT, reverse three times
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Array.
        //withReverse(nums, k);
        
        //Method 5, new array with length k
        //T, O(k+n), O(n), S, O(k)
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Array.
        //withArrayK(nums, k);
    }
    
    private void withArrayK(int [] nums, int k){
        int [] te = new int [k];
        for(int i = nums.length - k, j = 0; i < nums.length; i ++, j ++){
            te[j] = nums[i];
        }
        for(int i = nums.length - k - 1, j = nums.length - 1; i >= 0; i --, j --){
            nums[j] = nums[i];
        }
        for(int i = 0; i < k; i ++){
            nums[i] = te[i];
        }
    }
    
    private void withReverse(int [] nums, int k){
        //k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int [] nums, int start, int end){
        while(start < end){
            int te = nums[start];
            nums[start] = nums[end];
            nums[end] = te;
            start++;
            end--;
        }
    }
    
    private void withInPlace(int [] nums, int k){
        if(nums.length % k != 0){
            int location = 0, te = nums[0], tek = nums[k % nums.length];
            for(int i = 0; i < nums.length; i ++, location = (location + k) % nums.length){
                tek = nums[(location + k) % nums.length];
                nums[(location + k) % nums.length] = te;
                te = tek;
            }
        }else{
            System.out.println("K");
            for(int i = 0; i < k; i++){
                int location = i, te = nums[i], tek = nums[(k + i) % nums.length];
                for(int j = 0; j < nums.length / k; j ++, location = (location + k) % nums.length){
                    tek = nums[(location + k) % nums.length];
                    nums[(location + k) % nums.length] = te;
                    te = tek;
                }
            }
        }
    }
    
    private void withNewArrayStoringElements(int [] nums, int k){
        int [] te = new int [nums.length];
        for(int i = 0; i < te.length; i++){
            te[i] = nums[i];
        }
        //in case k is greater than the length of nums,
        //k %= nums.length;
        for(int i = 0; i < nums.length; i++){
            /**if(i < nums.length - k){
                nums[k+i] = te[i];
            }else{
                nums[i - nums.length + k] = te[i];
            }*/
            //Excellent
            nums[(i+k)%nums.length] = te[i];
        }
        //System.out.println(Arrays.toString(nums));
    }
    
    private void withBruteForce(int [] nums, int k){
        for( int i = 1; i <= k; i++){
            int j = nums.length - 1, te = nums[nums.length - 1];
            for( ; j > 0; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = te;
        }
    }
    
}
