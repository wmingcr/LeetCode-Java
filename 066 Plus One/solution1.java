//this one needs optimization, accepted first time
class Solution {
    public int[] plusOne(int[] digits) {
        //check valid
        if(digits.length == 0){
            return new int [0];
        }
        //check whether one digit is not 9 
        for(int i = 0; i < digits.length; i++){
            if(digits[i] != 9){
                return addArray(digits);
            }
        }
        //special case, if all digits are 9,
        int [] tem = new int[digits.length+1];
        for(int i = 0; i < tem.length; i++){
            if(i==0){
                tem[i] = 1;
            }else{
                tem[i] = 0;
            }
        }
        return tem;
    }
    //add one, 
    private int[] addArray(int [] arr) {
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] != 9){
                arr[i] += 1;
                return arr;
            }else{
                arr[i] = 0;
            }
        }
        return null;
    }
}
