class Solution {
    public int[] plusOne(int[] digits) {
        //if no elements,
        if(digits == null || digits.length == 0){
            return new int [0];
        }
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] != 9){//if not 9, then plus 1
                digits[i] += 1;
                return digits; 
            }else{//in this case, digits[i] = 9;
                digits[i] = 0;
            }
        }
        //all elements are 9
        int [] te = new int [digits.length + 1];
        te[0] = 1;
        return te;
    }
}
