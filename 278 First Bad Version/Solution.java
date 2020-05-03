/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        //validity
        if(n <= 0){
            return -1;
        }
        
        //initialization
        int left = 1, right = n;
        
        //binary search
        while(left <= right){
            
            //mid point
            int mid = left + ((right-left)>>1);
            
            if(isBadVersion(mid) == false){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        return left;
        
    }
}
