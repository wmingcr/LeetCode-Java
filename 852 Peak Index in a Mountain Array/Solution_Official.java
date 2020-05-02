//after review the official answer, we found that the condition for mid point could be more concise,
//there are only two conditions for mid point: A[mid] < A [mid+1] || A[mid] > A[mid+1]

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        //validity
        if(A == null || A.length == 0){
            return -1;
        }
        
        //official answer
        //for mid point, there are only two conditions: A[mid] < A [mid+1] || A[mid] > A[mid+1]
        //so we can make our code more concise 
        
        //initializing two pointers
        int left = 0, right = A.length-1;
        
        //binary search
        while(left < right){
            
            //mid point
            int mid = left + ((right-left)>>1);
            
            if(A[mid] < A[mid+1]){ // peak in right side
                left = mid+1;
            }else{
                right = mid; // peak in left side
            }
        }
        
        return left;
    }
}
