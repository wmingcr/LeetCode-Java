public class TheBest {
    class Solution {
        public int trap(int[] height) {

            int L = 0, R = height.length - 1;

            while (L < R && height[L] <= height[L + 1]) {
                L++;
            }

            while (L < R && height[R - 1] >= height[R]) {
                R--;
            }

            int res = 0;

            while (L < R) {
                int left = height[L];
                int right = height[R];
                if (left <= right) {
                    while (L < R && left >= height[++L]) {
                        res += left - height[L];
                    }
                } else {
                    while (L < R && right >= height[--R]) {
                        res += right - height[R];
                    }
                }
            }

            return res;
        }
    }
}
