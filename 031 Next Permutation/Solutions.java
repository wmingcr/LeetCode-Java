//see official solution from LeetCode

class Solution {
    public void nextPermutation(int[] nums) {
        //validity
        if(nums == null || nums.length <= 1){
            return;
        }
        /*
        //do permutation
        for(int i = nums.length-1; i > 0; i --){
            if(nums[i] > nums[i-1]){
                int k = i; 
                while(k < nums.length){
                    if(nums[k] <= nums[i-1]){
                        break;
                    }
                    k++;
                }
                swap(nums, i-1, k-1);
                reverse(nums, i, nums.length-1);
                return;
            }
        }
        reverse(nums, 0, nums.length-1);
        */
        
        //do optimization for above section
        int i = nums.length-2;
        while(i >= 0){
            if(nums[i] < nums[i+1]){
                break;
            }
            i--;
        }
        if(i >= 0){
            int k = nums.length-1;
            while(k > i){
                if(nums[k] > nums[i]){
                    break;
                }
                k--;
            }
            swap(nums, i, k);
        }
        reverse(nums, i+1, nums.length-1);
    }
    
    private void reverse(int [] nums, int left, int right){
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    
    private void swap(int [] nums, int a, int b){
        int te = nums[a];
        nums[a] = nums[b];
        nums[b] = te;
    }
}

