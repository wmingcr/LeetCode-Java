public class TwoForLoops {

    class Solution {
        public int romanToInt(String s) {

            if(s == null || s.length() == 0){
                return 0;
            }

            int sum = 0;

            for(int i = 0; i < s.length(); i ++){

                if (s.charAt(i) == 'I'){
                    sum += 1;
                }

                if (s.charAt(i) == 'V'){
                    sum += 5;
                }

                if (s.charAt(i) == 'X'){
                    sum += 10;
                }

                if (s.charAt(i) == 'L'){
                    sum += 50;
                }

                if (s.charAt(i) == 'C'){
                    sum += 100;
                }

                if (s.charAt(i) == 'D'){
                    sum += 500;
                }

                if (s.charAt(i) == 'M'){
                    sum += 1000;
                }

            }

            for (int i = 1; i < s.length(); i ++){

                if(s.charAt(i-1) == 'I' && s.charAt(i) == 'V'
                        || s.charAt(i-1) == 'I' && s.charAt(i) == 'X') {
                    sum -= 2;
                }

                if(s.charAt(i-1) == 'X' && s.charAt(i) == 'L'
                        || s.charAt(i-1) == 'X' && s.charAt(i) == 'C') {
                    sum -= 20;
                }

                if(s.charAt(i-1) == 'C' && s.charAt(i) == 'D'
                        || s.charAt(i-1) == 'C' && s.charAt(i) == 'M') {
                    sum -= 200;
                }
            }

            return sum;
        }
    }
}
