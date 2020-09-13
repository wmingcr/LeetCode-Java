public class FactorialNumberSystem {
    class Solution {
        public String getPermutation(int n, int k) {
            List<Integer> nums = new ArrayList<>();
            for(int i = 1; i < n + 1; i ++){
                nums.add(i);
            }

            int[] factorials = new int[n];
            factorials[0] = 1;
            for(int i = 1; i < n; i ++){
                factorials[i] = factorials[i - 1] * i;
            }

            k --;

            StringBuilder builder = new StringBuilder();
            // int len = n;
            // while(builder.length() != len){
            //     int idx = k / factorials[n - 1];
            //     k -= idx * factorials[n - 1];
            //     n--;
            //     builder.append(nums.get(idx));
            //     nums.remove(idx);
            // }

            for(int i = 1; i < n + 1; i ++){
                int idx = k / factorials[n - i];
                k -= idx * factorials[n - i];
                builder.append(nums.get(idx));
                nums.remove(idx);
            }

            return builder.toString();
        }
    }
}
