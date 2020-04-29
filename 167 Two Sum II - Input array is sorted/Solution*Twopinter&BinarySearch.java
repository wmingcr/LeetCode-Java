class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //validity
        if(numbers == null || numbers.length < 2){
            return new int [] {};
        }
        
        return twoPointers_BinarySerach(numbers, target);
    }
    
    private int [] twoPointers_BinarySerach(int [] arr, int target){
        int left = 0;
        int right = binarySerachForRightPosition(arr, target - arr[0]);
        while(left < right){
            if(target == arr[left] + arr[right])
                return new int [] {++left, ++right};
            else if (target < arr[left] + arr[right])
                right --;
            else
                left ++;
        }
        return new int [] {-1, -1};
    }
    
    private int binarySerachForRightPosition(int [] arr, int target){
        int left = 1, right = arr.length - 1;
        for( ; left <= right; ){
            int mid = left + ((right - left)>>1);
            if(target == arr[mid])
                return mid;
            else if(target < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left - 1;
    }
}
