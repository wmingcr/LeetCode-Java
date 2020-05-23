public class Solution_BS {


    class Solution {
        public int findBestValue(int[] arr, int target) {
            // validity
            if(arr == null || arr.length == 0){
                return -1;
            }
            // two pointers
            int left = 0, right = 1_000_000;
            // binary search, to find the sum just above target
            while(left < right){
                // mid pointer
                int mid = left + ((right - left) >> 1);
                long sum = getSum(arr, mid);
                if(sum < target) {
                    left = mid + 1;
                }
                else if (sum > target){
                    right = mid;
                } else {
                    return mid;
                }
//                } else {
//                    right = mid;
//                }
            }
//            int num1 = left;
//            long sum1 = getSum(arr, num1);
//            int num2 = left - 1;
//            long sum2 = getSum(arr, num2);
//            if(Math.abs(sum2 - target) <= Math.abs(sum1 - target)){
//                return num2;
//            }
//            return num1;

            long sum1 = getSum(arr, left);
            long sum2 = getSum(arr, left - 1);
            if((target - sum2) <= (sum1 - target)){
                return left - 1;
            }
            return left;

        }

        private long getSum(int[] arr, int mid){
            long sum = 0;
            for(int i : arr){
                sum += i <= mid ? i : mid;
            }
            return sum;
        }
    }
}
