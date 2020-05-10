// binary search

class Solution {
    public int mySqrt(int x) {
        
        //validity
        if(x < 0){
            return -1;
        }
        
        //corner case
        if(x < 2){
            return x;
        }
        
        //initialization
        //int left = 0, rigth = x;
        //even more, we know that sqrt(x) is less than x/2 when x>2, so:
        int left = 1, right = x/2;
        
        //binary search
        while(left <= right){
            
            //mid point
            int mid = left + ((right-left)>>1);
            
            //incase num is greater than Integer.MAX_VALUE
            long num = (long)mid*mid;
            
            if(num == x){
                return mid;
            }else if (num < x){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }
}
