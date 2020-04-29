class Solution {
    public int[] plusOne(int[] digits) {
        //if no elements,
        if(digits == null || digits.length == 0){
            return new int [0];
        }
        for(int i = digits.length - 1; i >= 0; i--){
            //no matter what, adding one first, then check whether it's 0 or not
            //very good*******************
            digits[i]++;
            digits[i] %= 10;
            if(digits[i] != 0){
                return digits;
            }
        }
        //all elements are 9
        int [] te = new int [digits.length + 1];
        te[0] = 1;
        return te;
    }
}
