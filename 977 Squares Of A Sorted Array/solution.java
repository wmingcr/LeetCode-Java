class Solution {
    public int[] sortedSquares(int[] A) {
        //check the array is valid or not
        if(A == null || A.length == 0){
            return null;
        }
        //create a new array, to store sorted sqaured values
        int [] arr = new int[A.length];
        //using two pointers, 
        for(int left = 0, right = A.length - 1, len = right; left <= right; ){
            if(Math.pow(A[right], 2) >= Math.pow(A[left], 2)){
                arr[len--] = A[right] * A[right];
                right --;
            }else{
                arr[len--] = A[left]*A[left];
                left++;
            }
        }
        return arr;
    }
}
