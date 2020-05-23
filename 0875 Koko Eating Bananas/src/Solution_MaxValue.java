public class Solution_MaxValue {

    class Solution {
        public int minEatingSpeed(int[] piles, int H) {
            // validity
            if(piles == null || H < piles.length){
                return -1;
            }
            // two pointers
            int min = 1;
            int max = piles[0];
            // find max
            for(int i = 1; i < piles.length; i++){
                if(piles[i] > max){
                    max = piles[i];
                }
            }
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
                if(num % speed == 0){
                    totalHour += num / speed;
                } else {
                    totalHour += num / speed + 1;
                }
            }
            if(totalHour <= h){
                return true;
            }
            return false;
        }
    }
}
