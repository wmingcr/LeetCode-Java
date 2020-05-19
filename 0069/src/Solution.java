class Solution {
    public int mySqrt(int x) {
        // 
        if(x < 0){
            return -1;
        }
        //
        if(x == 0){
            return 0;
        }
        if(x < 4){
            return 1;
        }
        // two pointer
        long left = 0, right = x/2 + 1;
        while(left < right){
            // mid
            long mid = left + ((right-left) >> 1);
            long square = mid*mid;
            if(square < x){
                left = mid + 1;
            } else if(square > x ){
                right = mid;
            } else {
                return (int)mid;
            }
        }
        return (int)(left-1);
    }
}

class Solution2 {
    public int mySqrt(int x) {
        // validity
        if(x < 0){
            return -1;
        }

        // two pointers
        long left = 0, right = x / 2 + 1;
        while(left < right){
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if(square > x){
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int)right;
    }
}