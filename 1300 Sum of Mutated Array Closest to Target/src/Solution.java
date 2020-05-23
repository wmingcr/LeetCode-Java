class Solution {
    public int findBestValue(int[] arr, int target) {
        // validity
        int max = arr[0];
        long sum = 0;

        for(int i : arr){
            sum += i;
            max = Math.max(max, i);
        }
        if(sum <= target){
            return max;
        }
        // update min
        int min = target / arr.length;
        long absDif = Long.MAX_VALUE;
        int ans = min;
        // binary search
        while(min <= max){
            // mid pointer
            int mid = min + ((max - min) >> 1);
            sum = 0;
            for(int i : arr){
                sum += i <= mid ? i : mid;
            }
            long newAbs = Math.abs(sum - target);
            if (newAbs < absDif){
                ans = mid;
                absDif = newAbs;
            }
            if(sum > target){
                max = mid;
            } else if (sum < target){
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return ans;
    }
}