class Solution {
    public int[] sortArrayByParity(int[] A) {
        //two pointers 
        for(int left = 0, right = A.length - 1; left < right; ){
            //From left side, if it's even, just ignore it
            if(A[left]%2 == 0){
                left++;
            }else if(A[right]%2 == 1){//From, right side, if it's odd, ignore it too
                right--;
            }else{//otherwise, swap them,
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                //important, dont forget to move them to next ellements
                left++;right--;
            }
        }
        return A;
    }
}
