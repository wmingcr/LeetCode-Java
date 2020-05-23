public class Solution_OptimizedRoundUp {

    class Solution {
        public int minEatingSpeed(int[] piles, int H) {
            // validity
            if(piles == null || H < piles.length){
                return -1;
            }
            // two pointers
            int min = 1;
            int max = 1_000_000;
            // binary search
            while(min <= max){
                // mid pointer
                int mid = min + ((max - min) >> 1);
                if(success(mid, H, piles)){
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            return max + 1;
        }

        private boolean success(int speed, int h, int[] piles){
            int totalHour = 0;
            for(int num : piles){
                // round up could be like this
                // > 96.88%, same as (num - 1) / speed + 1;
                totalHour += (num + speed - 1) / speed;

                // if(num % speed == 0){
                //     totalHour += num / speed;
                // } else {
                //     totalHour += num / speed + 1;
                // }
            }
            if(totalHour <= h){
                return true;
            }
            return false;
        }
    }
}
