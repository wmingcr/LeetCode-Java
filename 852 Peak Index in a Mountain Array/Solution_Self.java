class Solution {
    public int peakIndexInMountainArray(int[] A) {
        //validity
        if(A == null || A.length == 0){
            return -1;
        }
        
        //binary search
        //initializing two pointers
        int left = 0, right = A.length-1;
        
        //initializing answer
        int ans = A[0];
        
        //while loop
        while(left <= right){
            
            //mid point
            int mid = left + ((right- left) >> 1);
            
            //condition for peak
            if( mid==0&&A[0]>A[1] // A[0] is the peak
               || (mid==A.length-1)&&A[A.length-1]>A[A.length-2] // A[A.length-1] is the peak
               || A[mid] > A[mid-1] && A[mid] > A[mid+1]){ // mid is the peak index
                ans = mid;
                break;
            }
            
            if(A[mid-1] < A[mid] && A[mid] < A[mid+1]){
                left = mid+1;//peak in the right side
            }else{
                right = mid-1;//peak in the left side
            }
            
        }
        return ans;
    }
}
