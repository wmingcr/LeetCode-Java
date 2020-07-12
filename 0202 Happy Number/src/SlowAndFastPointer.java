public class SlowAndFastPointer {

    class Solution {
        public boolean isHappy(int n) {
            // corner case
            if(n == 1){
                return true;
            }
            // slow and fast pointers
            int a = n;
            int b = n;
            // since b is the faster pinter
            // there is no need to check whether a == 1
            while(/*a != 1 && */b != 1){
                int curr = 0;
                while(a != 0){
                    int te = a%10;
                    curr += te * te;
                    a /= 10;
                }
                a = curr;
                curr = 0;
                while(b != 0){
                    int te = b%10;
                    curr += te * te;
                    b /= 10;
                }
                b = curr;
                if(b == 1){
                    return true;
                }
                curr = 0;
                while(b != 0){
                    int te = b%10;
                    curr += te * te;
                    b /= 10;
                }
                b = curr;
                if(a == b){
                    return false;
                }
            }
            // b == 1
            return true;
        }
    }
}
