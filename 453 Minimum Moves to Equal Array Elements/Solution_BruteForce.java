class Solution {
    public int minMoves(int[] nums) {
        int step = 0;

        while (true) {
            int minIdx = findMin (nums);
            int maxIdx = findMax (nums);
            if (minIdx == maxIdx) {
                break;
            }
            increaseBy1 (nums, maxIdx);
            step++;
        }

        return step;
    }

    private void increaseBy1(int[] arr, int maxIdx) {
        for (int i = 0; i < arr.length; i++) {
            if (i != maxIdx) {
                arr[i] += 1;
            }
        }
    }

    private int findMin(int[] arr) {
        int min = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        return min;
    }

    private int findMax(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }
}


//------------------------------------

class Solution {
    public int minMoves(int[] nums) {
        //validity
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int min = 0, max = 0, step = 0;
        
        while(true){
            
            for(int i = 1; i < nums.length; i ++){
                if(nums[i] < nums[min]){
                    min = i;
                }
                if(nums[i] > nums[max]){
                    max = i;
                }
            }
            
            if(nums[min] == nums[max]){
                break;
            }
            
            for(int i = 0; i < nums.length; i ++){
                if(i != max){
                    nums[i] += 1;
                }
            }
            step++;
        }
        return step;
    }
}
