public class SlowFastPointers {


    class Solution {
        public boolean isHappy(int n) {
            // corner case
            if(n == 1){
                return true;
            }

            int slow = n;
            int fast = get(n);

            while(fast != 1 && fast != slow){
                slow = get(slow);
                fast = get(get(fast));
            }

            return fast == 1;
        }

        private int get(int n){
            int cur = 0;
            while(n > 0){
                int t = n%10;
                cur += t*t;
                n /= 10;
            }
            return cur;
        }
    }
}
