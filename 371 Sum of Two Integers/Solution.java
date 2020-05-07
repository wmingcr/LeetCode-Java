class Solution {
    public int getSum(int a, int b) {
        //corner case
        if(a == 0){
            return b;
        }
        
        //corner case
        if(b == 0){
            return a;
        }
        
        int low = 0;
        
        while(true){
            low = a^b;
            int carrier = a&b;
            
            if(carrier == 0){
                break;
            }
            
            a = low;
            b = carrier << 1;
        }
        
        return low;
    }
}
