class Solution {
    public int reverse(int x) {
        //there is no need to check variable x, it can't be null,
        int result = 0;
        
        while(x!=0){
            int a = x%10;
            x = x/10;
            if((result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && a > 7)) || result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE && a < -8)){
                return 0;
            }
            result = result * 10 + a;
        }
        
        return result;
    }
}
