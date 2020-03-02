class Solution {
    public void moveZeroes(int[] nums) {
        //check validity
        if(nums == null || nums.length <= 1){
            return;
        }
        
        /** Method 1, Two pointers, 
        * left for 0, right for non-zero elments and at the right position of left
        * relying on left, reset right every time
        * Runtime: 4 ms, faster than 13.73%, what??
        */
        //twoPointers(nums);
        
        /** Method 2, move none zeros
        * Excellent, 
        * 
        */
        //moveZeros(nums);
        
        /** Method 2', Optimization, move zeros
        * 
        */
        //moveZerosOpti(nums);
        
        /** Method 1', Two pointers optimization
        * only one loop, rely on right looking for non-zeros
        */
        //twoPointersOpti(nums);
        
        /** Method 3, Two pointer, one loop,
        *
        */
        twoPointersOpt3_1(nums);
    }
    
    private void twoPointersOpt3_1(int [] nums){
        int pos = 0;
        for(int num : nums){
            if(num != 0){
                nums[pos++] = num;
            }
        }
        while(pos<nums.length){
            nums[pos++] = 0;
        }
    }
    
    private void twoPointersOpt3(int [] nums){
        for(int i = 0, j = 0; j < nums.length; j++){
            if(nums[j] != 0){
                swap(nums, i, j);
                i++;
            }
        }
    }
    
    private void twoPointersOpti(int [] nums){
        for(int left = 0, right = 0; right < nums.length; right++){
            if(nums[right] != 0){
                if(left == right){
                    left++;
                    continue;
                }
                nums[left++] = nums[right];
                nums[right] = 0;//dont put right++ here, if the condition couldn't happen, right couldn't plus one, then it's endless loop
            }
        }
    }
    
    private void moveZerosOpti(int [] nums){
        int pos = 0;
        for(int num : nums){
            if(num != 0)
                nums[pos++] = num;
        }
        while(pos < nums.length)
            nums[pos++] = 0;
    }
    
    private void moveZeros(int [] nums){
        int leftPosition = 0, i = 0;
        while(i < nums.length){//it will never happen, since (i < nums.length && nums[i] != 0)
            if(nums[i] != 0){
                nums[leftPosition++] = nums[i];
            }
            i ++;
        }
        while(leftPosition < nums.length){
            nums[leftPosition++] = 0;
        }
    }
    
    private void swap(int[] nums, int left, int right){
        int te = nums[left];
        nums[left] = nums[right];
        nums[right] = te;
    }
    
    private void twoPointers(int [] nums){
        //left pointer is looking for elements that are 0
        for(int left = 0; true; ){
            while(left < nums.length && nums[left] != 0){//left out of bound, have to check every time
                left ++;
            }
            //only swap elements that are not 0 and at the right position of left
            //everytime, left is from a new beginning, which means inefficient
            int right = left + 1;
            while(right < nums.length && nums[right] == 0){//checking for out of bound should be in the first place
                right++;
            }
            if(right < nums.length){
                nums[left] = nums[right];
                nums[right] = 0;
                /**
                //no need to swap
                swap(nums, left, right);
                */
            }else{//if right >= length, which means there are no none-zero elements in the right
                return;
            }
        }
    }
}
