public class Session {

    public static void main(String[] args) {

        int [] arr = {2,0,2,1,1,0};

        new Solution ().sortColors (arr);
    }
}
class Solution {
    public void sortColors(int[] nums) {
        // validity
        if(nums == null || nums.length <= 1){
            return;
        }

        // get length,
        int n = nums.length;
        // three pointers
        int k = 0; // third pointer, pointing to right edge of 0s
        int lo = 0, hi = n-1;
        while(lo < hi){
            while(lo < hi && nums[lo] == 0){ // left 0s on left side
                lo ++;
            }
            while(k < n && nums[k] == 0){
                k++;
            }
            while(lo < hi && nums[hi] == 2){ // left 2s on right side
                hi -- ;
            }
            while(lo < hi){
                if(nums[lo] == 1){
                    swap(nums, k++, lo);
                } else if (nums[lo] == 2){
                    swap(nums, lo, hi--);
                } else {
                    break;
                }
            }
        }
    }

    private void swap(int[] arr, int a, int b){
        int te = arr[a];
        arr[a] = arr[b];
        arr[b] = te;
    }
}