public class TwoForLoopsOptimized {

    class Solution {
        public int romanToInt(String s) {

            if(s == null || s.length() == 0){
                return 0;
            }

            int sum = 0;

            for(int i = 0; i < s.length(); i ++){

                // if there are more than 2 times of using API
                // record it with a variable, saving time;
                char c = s.charAt(i);

                if (c == 'I'){
                    sum += 1;
                }

                if (c == 'V'){
                    sum += 5;
                }

                if (c == 'X'){
                    sum += 10;
                }

                if (c == 'L'){
                    sum += 50;
                }

                if (c == 'C'){
                    sum += 100;
                }

                if (c == 'D'){
                    sum += 500;
                }

                if (c == 'M'){
                    sum += 1000;
                }

            }

            for (int i = 1; i < s.length(); i ++){

                char c = s.charAt(i-1);
                char d = s.charAt(i);

                if(c == 'I' && d == 'V'
                        || c == 'I' && d == 'X') {
                    sum -= 2;
                }

                if(c == 'X' && d == 'L'
                        || c == 'X' && d == 'C') {
                    sum -= 20;
                }

                if(c == 'C' && d == 'D'
                        || c == 'C' && d == 'M') {
                    sum -= 200;
                }
            }

            return sum;
        }
    }
}
